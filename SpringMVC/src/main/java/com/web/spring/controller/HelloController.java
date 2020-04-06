package com.web.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.spring.beans.NewUser;
import com.web.spring.beans.UserDetail;
import com.web.spring.services.ImageUploadService;
import com.web.spring.services.UserService;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HelloController {

	
	@Autowired
	private UserService userservice;

	@Autowired
	private ImageUploadService imageService;

	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("newUser") NewUser newUser) {
		ModelAndView model = new ModelAndView();
		model.setViewName("../login");
		userservice.addUser(newUser);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("userdetail") UserDetail userdetail) {

		ModelAndView model = new ModelAndView();

		List<NewUser> loginUser = userservice.getUserDetail(userdetail);

		// userdao.saveUserdetails(loginUserdetails);

		if (loginUser.size() > 0) {
			// Perform Logic for session management
			model.setViewName("profile");
			model.addObject("loginUser", loginUser);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("loginUser", loginUser);
			return model;
		} else {

		}

		return null;
	}
	
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadImagesPage( @RequestParam CommonsMultipartFile[] fileupload,
			@ModelAttribute ModelMap modelMap) throws Exception {

		HttpSession session = request.getSession();
		List<NewUser> loginUser = (List<NewUser>) session.getAttribute("loginUser");
		
		NewUser newuser = loginUser.get(0);
		
		
		/*Iterator<NewUser> itr = loginUser.iterator();
		while(itr.hasNext()){
			NewUser user = itr.next();
			user.getId();
		}
		System.out.println(newuser);
		System.out.println(newuser.getId().toString());*/
		
		String folderName = newuser.getId().toString();
		String path = "D:/VipinBackup/SpringHibernateApp/src/main/webapp/WEB-INF/resources/images/uploadedImages/";
		String directoryName = path.concat(folderName);
		
		File directory = new File(directoryName);
		
		 if (! directory.exists()){
		        directory.mkdir();
		    }
		
		if (fileupload != null && fileupload.length > 0) {
			for (CommonsMultipartFile image : fileupload) {

				String fileName = image.getOriginalFilename();
				System.out.println("Saving file: " + fileName);

				byte barr[] = image.getBytes();
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(
						directoryName +"/" + fileName));

				bout.write(barr);
				bout.flush();
				bout.close();

			/*	
				  ImageUpload imageupload = new ImageUpload();
				  imageupload.setFileName(image.getOriginalFilename());
				  imageupload.setData(image.getBytes());
				  imageService.addImages(imageupload);
				 */
			}
		}
		modelMap.addAttribute("loginUser", loginUser);
		return "redirect:profile_Page";
	}
	
	@ResponseBody
	@RequestMapping(value = "/imagelist",method = { RequestMethod.POST, RequestMethod.GET }, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getImageList() {
		List<String> imageList = new ArrayList<String>();
		
		HttpSession session = request.getSession();
		List<NewUser> loginUser = (List<NewUser>) session.getAttribute("loginUser");
		NewUser newuser = loginUser.get(0);
		
		String folderName = newuser.getId().toString();
		String path = "D:/VipinBackup/SpringHibernateApp/src/main/webapp/WEB-INF/resources/images/uploadedImages/";
		String directoryName = path.concat(folderName);
		
		File file = new File(directoryName);
		if ( file.exists()){
			File[] listOfFiles = file.listFiles();
			 for (File f: listOfFiles) {
		           if (f.isFile()) {
		           
		               imageList.add(folderName.concat("/").concat(f.getName()));
		           } 
		       } 
	    }
		
		
	/*	imageList.add("123.jpg");
		imageList.add("1234.jpg");
		imageList.add("12345.jpg");*/
		return imageList;
	}

	@RequestMapping(value = "/people", method = RequestMethod.POST)
	public ModelAndView peopleSearch() {

		ModelAndView model = new ModelAndView();
		List<NewUser> list = userservice.getUsers();
		model.setViewName("people");
		model.addObject("peopleList", list);

		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		HttpSession session = request.getSession();
		System.out.println("session id before invalidating it:" + session.getId());
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
			try {
				try {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (ServletException e) {
				e.printStackTrace();
			}
			
	}
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String showImages( ) {
		/*List<ImageUpload> list = new ArrayList<ImageUpload>();
		ObjectMapper mapper = new ObjectMapper();
		
		list = imageService.getImages();
		
		String json = "";
		try {
			json = mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return null;
		
	}
	
	@RequestMapping(value = "/profile_Page",method = { RequestMethod.POST, RequestMethod.GET })
	public String profile(@ModelAttribute ModelMap modelMap) throws Exception {

		HttpSession session = request.getSession();
		List<NewUser> loginUser = (List<NewUser>) session.getAttribute("loginUser");
		modelMap.addAttribute("loginUser", loginUser);
		return "profile";
		
	}
	
	
	/*@RequestMapping(value = "/OAuth", method = RequestMethod.POST)
	public void OAuth(HttpServletRequest req, HttpServletResponse resp){
		
		 try {
	            String idToken = req.getParameter("id_token");
	            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
	            String name = (String) payLoad.get("name");
	            String email = payLoad.getEmail();
	            System.out.println("User name: " + name);
	            System.out.println("User email: " + email);

	            HttpSession session = req.getSession(true);
	            session.setAttribute("userName", name);
	            req.getServletContext()
	               .getRequestDispatcher("/welcome-page.jsp").forward(req, resp);

	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}*/
	
/*	


	@RequestMapping(value = "/list", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User jQueryExample(@ModelAttribute User user) {
		//ObjectMapper mapper = new ObjectMapper();
		ModelAndView model = new ModelAndView();
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("abc");
		list.add("ab");
		list.add("a");
		model.addObject(user);
		
	//	model.setViewName("something");
		
		String json = "";
		try {
			json = mapper.writeValueAsString(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("somelist", json);

 		return user;
	}
	
	@RequestMapping(value = "/something", method = RequestMethod.GET)
	public String something() {

		
		return "something";
	}
*/
}

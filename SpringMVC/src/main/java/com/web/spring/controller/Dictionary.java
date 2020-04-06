package com.web.spring.controller;
	import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

	public class Dictionary {
	    private int M = 1319; //prime number
	    final private Bucket[] array;
	    public Dictionary() {
	        this.M = M;

	        array = new Bucket[M];
	        for (int i = 0; i < M; i++) {
	            array[i] = new Bucket();
	        }
	    }

	    private int hash(String key) {
	        return (key.hashCode() & 0x7fffffff) % M;
	    }

	    //call hash() to decide which bucket to put it in, do it.
	    public void add(String key) {
	        array[hash(key)].put(key);
	    }

	    //call hash() to find what bucket it's in, get it from that bucket. 
	    public boolean contains(String input) {
	        input = input.toLowerCase();
	        return array[hash(input)].get(input);
	    }

	    public void build(String filePath) {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(filePath));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                add(line);
	            }
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }

	    }
	   

	    class Bucket {

	        private Node first;

	        public boolean get(String in) {         //return key true if key exists
	            Node next = first;
	            while (next != null) {
	                if (next.word.equals(in)) {
	                    return true;
	                }
	                next = next.next;
	            }
	            return false;
	        }

	        public void put(String key) {
	            for (Node curr = first; curr != null; curr = curr.next) {
	                if (key.equals(curr.word)) {
	                    return;                     //search hit: return
	                }
	            }
	            first = new Node(key, first); //search miss: add new node
	        }

	        class Node {

	            String word;
	            Node next;

	            public Node(String key, Node next) {
	                this.word = key;
	                this.next = next;
	            }

	        }

	    }
	}


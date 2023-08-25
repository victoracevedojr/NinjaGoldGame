package com.codingdojo.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	Date date = new Date();
	Random rand = new Random();
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("myGold") == null) {
			session.setAttribute("myGold", 0);
			session.setAttribute("messages", new ArrayList<String>());
		} else {
			int myGold = (Integer) session.getAttribute("myGold");
			session.setAttribute("myGold", myGold);
			session.setAttribute("messages", session.getAttribute("messages"));
		}
		return "index.jsp";
	}
	
	@PostMapping("/action/{location}")
	public String location(@PathVariable("location") String location, HttpSession session) {
		if(location.equals("farm")) {
			int addGold = rand.nextInt(10,21);
			int myGold = (Integer) session.getAttribute("myGold");
			session.setAttribute("myGold", myGold + addGold);
			String message = String.format("You entered a farm and earned %d gold. (%s)", addGold, date);
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			messages.add(0,message);
			session.setAttribute("messages", messages);
			return "redirect:/";
		} else if (location.equals("cave")) {
			int addGold = rand.nextInt(5,11);
			int myGold = (Integer) session.getAttribute("myGold");
			session.setAttribute("myGold", myGold + addGold);
			String message = String.format("You entered a cave and earned %d gold. (%s)", addGold, date);
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			messages.add(0,message);
			session.setAttribute("messages", messages);
			return "redirect:/";
		} else if(location.equals("house")) {
			int addGold = rand.nextInt(2,6);
			int myGold = (Integer) session.getAttribute("myGold");
			session.setAttribute("myGold", myGold + addGold);
			String message = String.format("You entered a house and earned %d gold. (%s)", addGold, date);
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			messages.add(0,message);
			session.setAttribute("messages", messages);
			return "redirect:/";
		} else if(location.equals("quest")) {
			double sign = rand.nextDouble();
			int deltaGold = rand.nextInt(0,51);
			int myGold = (Integer) session.getAttribute("myGold");
			if(sign<0.5) {
				session.setAttribute("myGold", myGold + deltaGold);
				String message = String.format("You completed a quest and earned %d gold. (%s)", deltaGold, date);
				ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
				messages.add(0,message);
				session.setAttribute("messages", messages);
				return "redirect:/";
			} else {
				if(myGold - deltaGold>=0) {
					session.setAttribute("myGold", myGold - deltaGold);
					String message = String.format("You failed a quest and lost %d gold. (%s)", deltaGold, date);
					ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
					messages.add(0,message);
					session.setAttribute("messages", messages);
					return "redirect:/";
				} else {
					session.setAttribute("myGold", 0);
					String message = String.format("You failed a quest and have no gold now. (%s)\n", date);
					ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
					messages.add(0,message);
					session.setAttribute("messages", messages);
					return "redirect:/fail";
				}
			}
		} else if(location.equals("spa")) {
			int subtractGold = rand.nextInt(5,21);
			int myGold = (Integer) session.getAttribute("myGold");
			if(myGold - subtractGold>=0) {
				session.setAttribute("myGold", myGold - subtractGold);
				String message = String.format("You visited a spa and lost %d gold. (%s)", subtractGold, date);
				ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
				messages.add(0,message);
				session.setAttribute("messages", messages);
				return "redirect:/";
			} else {
				session.setAttribute("myGold", 0);
				String message = String.format("You visited a spa and have no gold now. (%s)\n", date);
				ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
				messages.add(0,message);
				session.setAttribute("messages", messages);
				return "redirect:/fail";
			}
		}
		return "redirect:/";
	}
	
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("myGold", 0);
		session.setAttribute("messages", new ArrayList<String>());
		return "redirect:/";
	}
	
	@GetMapping("/fail")
	public String fail(HttpSession session) {
		session.setAttribute("myGold", 0);
		session.setAttribute("messages", new ArrayList<String>());
		return "fail.jsp";
	}
}

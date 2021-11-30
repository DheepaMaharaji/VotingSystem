package com.wipro.votingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.votingsystem.entity.Candidate;
import com.wipro.votingsystem.entity.Citizen;
import com.wipro.votingsystem.repositories.CandidateRepo;
import com.wipro.votingsystem.repositories.CitizenRepo;

@Controller
public class VotingController {

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired 
	CandidateRepo candidateRepo;
	
	@RequestMapping("/vote")
	public String vote(@RequestParam String name, Model model, HttpSession session) {
		Citizen citizen = citizenRepo.findByName(name);
		session.setAttribute("citizen", citizen);
		
		if(!citizen.getHasVoted()) {
			
			List<Candidate> c=candidateRepo.findAll();
			model.addAttribute("candidates",c);
			return "doVote.html";
			
			
		}else {
			return "Thankyou.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {
		
		Citizen citizen =(Citizen) session.getAttribute("citizen");
		citizen.setHasVoted(true);
		
		Candidate can= candidateRepo.findById((long) id);
		can.setNumberOfVotes(can.getNumberOfVotes()+1);
		candidateRepo.save(can);
		
		citizenRepo.save(citizen);
		
		return "Thankyou.html";
	}
}

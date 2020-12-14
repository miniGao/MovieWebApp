package com.spring.webapp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {
	@Autowired
	private ITicketRepository ticketRepo;
	
	@GetMapping("/listOfTickets")
	public String ticketHome(Model model) {
		model.addAttribute("ticketList", ticketRepo.findAll());
		return "listOfTickets";
	}
	
	@GetMapping("/addTicket")
	public String addTicket(Ticket ticket) {
		return "addTicket";
	}
	
	@PostMapping("/createTicket")
	public String createTicket(@Valid Ticket ticket, BindingResult result, Model model) {
		if(result.hasErrors()) return "addTicket";
		ticketRepo.save(ticket);
		model.addAttribute("ticketList", ticketRepo.findAll());
		return "bookingSuccess";
	}
	
	@GetMapping("/editTicket/{id}")
	public String editTicket(@PathVariable("id") int ticketId, Model model) {
		Ticket ticket = ticketRepo.findById(ticketId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid ticket ID: " + ticketId));
		model.addAttribute("ticket", ticket);
		return "updateTicket";
	}
	
	@PostMapping("/updateTicket/{id}")
	public String updateTicket(@PathVariable("id") int ticketId, @Valid Ticket ticket, BindingResult result, Model model) {
		ticket.setTicketId(ticketId);
		if(result.hasErrors()) return "updateTicket";
		ticketRepo.save(ticket);
		model.addAttribute("ticketList", ticketRepo.findAll());
		return "bookingSuccess";
	}
	
	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable("id") int ticketId, Model model) {
		Ticket ticket = ticketRepo.findById(ticketId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid ticket ID: " + ticketId));
		ticketRepo.delete(ticket);
		model.addAttribute("ticketList", ticketRepo.findAll());
		return "listOfTickets";
	}
}

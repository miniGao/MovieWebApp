package com.spring.webapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ticketId;
	@NotBlank(message="Movie name required")
	private String movieName;
	@NotNull(message="Customer Id required")
	@Min(value=1, message="Customer Id must not be less than 1")
	private int custId;
	@NotNull(message="Payment Amount required")
	@Min(value=1, message="Amount must be more than 1.00")
	private double amountPaid;
	@NotNull(message="Number of Ticket required")
	@Min(value=1, message="Number must not be less than 1")
	private int numberOfTicket;
	@NotNull(message="Date required")
	@Future(message="Future Date required")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@NotNull(message="Time required")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	private Date time;
	@NotBlank(message="Venue required")
	private String venue;
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public int getNumberOfTicket() {
		return numberOfTicket;
	}
	public void setNumberOfTicket(int numberOfTicket) {
		this.numberOfTicket = numberOfTicket;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}

}

package com.topuploan.entity;

import javax.persistence.*;
@Entity
@Table
public class FeedBackModule {
    @Id
    @GeneratedValue(generator = "increment")
    private int id ;
    private String name;
    private String comments;
    private String rating;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private LoanModel loanModel;
    public FeedBackModule() {
    }
	public FeedBackModule(int id, String comments, String rating, String name) {
		super();
		this.id = id;
		this.name= name;
		this.comments = comments;
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public LoanModel getLoanModel() {
		return loanModel;
	}
	public void setLoanModel(LoanModel loanModel) {
		this.loanModel = loanModel;
	}
	
}
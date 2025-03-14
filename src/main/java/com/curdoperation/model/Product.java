package com.curdoperation.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private double price;
	
	private boolean active;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@CreationTimestamp
	private Date createdTimeStamp;
	
	@UpdateTimestamp
	private Date updatedTimeStamp;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable=false)
	private Category category;

	
}

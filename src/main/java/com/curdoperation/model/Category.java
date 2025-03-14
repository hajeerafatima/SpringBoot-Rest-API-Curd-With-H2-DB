package com.curdoperation.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
public class Category {   //category  ->  categories

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="cname", unique = true, nullable=false)
	private String name;   // name  -> cname  nallable uniaue
	
	@CreationTimestamp
	private Date createdTime;
	
	@UpdateTimestamp
	private Date updateTime;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private Set<Product> products = new HashSet<>();
}

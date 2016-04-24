package com.divya.myfandangoo.entity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.entity.Theatre;

@Entity
@Table(name = "theatre")
public class TheatreImpl implements Theatre {
	@Id
	@Column(name = "theatreId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	@Column
	private String theatreName;
	@Column
	private int theatreLocation;
	
	@OneToMany(mappedBy = "theatre", targetEntity=ShowImpl.class, cascade=CascadeType.ALL)
	private List<Show> show;
	
	public List<Show> getShow() {
		return show;
	}
	public void setShow(Show show) {
		if(this.show==null){
			this.show = new ArrayList<>(); 
		}
		this.show.add(show);
	}
	public TheatreImpl(){}
	public TheatreImpl(int theatreId,String theatreName,int theatreLocation) {
		this.theatreId=theatreId;
		this.theatreLocation=theatreLocation;
		this.theatreName=theatreName;
	}
	@Override
	public int getTheatreId() {
		return theatreId;
	}

	@Override
	public String getTheatreName() {
		return theatreName;
	}

	@Override
	public int getTheatreLocation() {
		return theatreLocation;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public void setTheatreLocation(int theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	
	@Override
	public String toString() {
		return "Threatre Id :" + theatreId +" Threatre Name :" + theatreName + " Theatre Location : "+theatreLocation;
	}

}

package com.girish.restaurants.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MenusItem{

	@SerializedName("popular_items")
	private List<PopularItemsItem> popularItems;

	@SerializedName("is_catering")
	private boolean isCatering;

	@SerializedName("subtitle")
	private String subtitle;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setPopularItems(List<PopularItemsItem> popularItems){
		this.popularItems = popularItems;
	}

	public List<PopularItemsItem> getPopularItems(){
		return popularItems;
	}

	public void setIsCatering(boolean isCatering){
		this.isCatering = isCatering;
	}

	public boolean isIsCatering(){
		return isCatering;
	}

	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getSubtitle(){
		return subtitle;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
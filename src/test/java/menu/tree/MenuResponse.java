package menu.tree;

import java.util.List;

public class MenuResponse{

    private int id;
	
	private String menuTitle;
	
    private int parentId;
	
	private String menuDesc;
	
	private String menuUrl="";
	
	private int sort;
	
	private String icon="";
	
	private List<MenuResponse> children;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getMenuTitle(){
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle){
		this.menuTitle = menuTitle;
	}

	public int getParentId(){
		return parentId;
	}

	public void setParentId(int parentId){
		this.parentId = parentId;
	}

	public String getMenuDesc(){
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc){
		this.menuDesc = menuDesc;
	}

	public String getMenuUrl(){
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl){
		this.menuUrl = menuUrl;
	}

	public int getSort(){
		return sort;
	}

	public void setSort(int sort){
		this.sort = sort;
	}

	public List<MenuResponse> getChildren(){
		return children;
	}

	public void setChildren(List<MenuResponse> children){
		this.children = children;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "MenuResponse [id=" + id + ", menuTitle=" + menuTitle + ", parentId=" + parentId + ", menuDesc="
				+ menuDesc + ", menuUrl=" + menuUrl + ", sort=" + sort + ", icon=" + icon 
				+ ", children=" + children + "]";
	}

}

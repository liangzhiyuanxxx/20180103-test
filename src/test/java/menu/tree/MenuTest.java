package menu.tree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class MenuTest {
	
	
	public static List<MenuResponse> menuTree(List<SystemMenu> menus){
		List<MenuResponse> responses = new ArrayList<MenuResponse>();
		
		for(SystemMenu systemMenu:menus){
			if(systemMenu.getParentId()==0){
				MenuResponse response = beanToResponse(systemMenu);
				response.setChildren(setChildMenu(systemMenu.getId(),menus));
				responses.add(response);
			}
		}
		return responses;
	}
	
	public static List<MenuResponse> setChildMenu(int id,List<SystemMenu> menus){

		List<MenuResponse> children = new ArrayList<MenuResponse>();
		for(SystemMenu systemMenu:menus){
			if(id==systemMenu.getParentId()){
				MenuResponse response = beanToResponse(systemMenu);
				response.setChildren(setChildMenu(systemMenu.getId(),menus));
				children.add(response);
			}
		}
		return children;
	}
	
	public static MenuResponse beanToResponse(SystemMenu systemMenu){
		MenuResponse response = new MenuResponse();
		response.setId(systemMenu.getId());
		response.setMenuDesc(systemMenu.getMenuDesc());
		response.setMenuTitle(systemMenu.getMenuTitle());
		response.setMenuUrl(systemMenu.getMenuUrl());
		response.setSort(systemMenu.getSort());
		response.setIcon(systemMenu.getIcon());
		return response;
	}
	
	public static void main(String[] args) {
		List<SystemMenu> menus = new ArrayList<SystemMenu>();
		//int id, String menuTitle, int parentId, String realm, String menuDesc, String menuUrl, int sort,
		//String icon, Date updateTime, Date createTime
		menus.add(new SystemMenu(1,"menuTitle1",0,"realm1","menuDesc1","menuUrl1",1,"icon1",new Date(),new Date()));
		menus.add(new SystemMenu(2,"menuTitle2",0,"realm2","menuDesc2","menuUrl2",1,"icon2",new Date(),new Date()));
		menus.add(new SystemMenu(3,"menuTitle3",1,"realm3","menuDesc3","menuUrl3",1,"icon3",new Date(),new Date()));
		menus.add(new SystemMenu(4,"menuTitle4",1,"realm4","menuDesc4","menuUrl4",1,"icon4",new Date(),new Date()));
		menus.add(new SystemMenu(5,"menuTitle5",3,"realm5","menuDesc5","menuUrl5",1,"icon5",new Date(),new Date()));
		menus.add(new SystemMenu(6,"menuTitle6",5,"realm6","menuDesc6","menuUrl6",1,"icon6",new Date(),new Date()));
		menus.add(new SystemMenu(7,"menuTitle7",6,"realm7","menuDesc7","menuUrl7",1,"icon7",new Date(),new Date()));
		menus.add(new SystemMenu(8,"menuTitle8",2,"realm8","menuDesc8","menuUrl8",1,"icon8",new Date(),new Date()));
		menus.add(new SystemMenu(9,"menuTitle9",3,"realm9","menuDesc9","menuUrl9",1,"icon9",new Date(),new Date()));
		System.out.println(MenuTest.menuTree(menus));
	}
}

package menu.tree;

import java.util.Date;

public class SystemMenu {
	
    private int id;
	
	private String menuTitle;
	
    private int parentId;
	
	private String realm;
	
	private String menuDesc;
	
	private String menuUrl="";
	
	private int sort;
	
	private String icon;
	
	private Date updateTime;
	
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SystemMenu [id=" + id + ", menuTitle=" + menuTitle + ", parentId=" + parentId + ", realm=" + realm
				+ ", menuDesc=" + menuDesc + ", menuUrl=" + menuUrl + ", sort=" + sort + ", icon=" + icon
				+ ", updateTime=" + updateTime + ", createTime=" + createTime + "]";
	}

	public SystemMenu(int id, String menuTitle, int parentId, String realm, String menuDesc, String menuUrl, int sort,
			String icon, Date updateTime, Date createTime) {
		super();
		this.id = id;
		this.menuTitle = menuTitle;
		this.parentId = parentId;
		this.realm = realm;
		this.menuDesc = menuDesc;
		this.menuUrl = menuUrl;
		this.sort = sort;
		this.icon = icon;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	public SystemMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

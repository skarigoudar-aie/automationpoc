package com.mk.testframework.core.data;

import com.mk.testframework.core.exceptions.TestException;

/**
 * @author VThipperudrappa
 *
 */
public class Product {
	public String styleName;
	public String collectionName;
	public ProductName productName;
	public String category = "UNDEFINED";
	public String store = "UNDEFINED";

	public String alias = "UNDEFINED";
	private String language;

	public String getStyleName() {
		return styleName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public String getProductName() {
		if (this.language.equals("en")) {
			return productName.getEn();
		} else if (this.language.equals("es")){
			return productName.getEs();
		}  else if (this.language.equals("fr")){
			return productName.getFr();
		}  else if (this.language.equals("de")){
			return productName.getDe();
		} else if (this.language.equals("it")){
			return productName.getIt();
		} else {
			throw new TestException("Not yet implemented");
		}
	}

	public String getCategory() {
		return category;
	}

	public String getStore() {
		return store;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	private class ProductName {
		public String en;
		public String es;
		public String fr;
		public String de;
		public String it;
		
		public String getEn() {
			return en;
		}

		public String getEs() {
			return es;
		}
		
		public String getFr() {
			return fr;
		}
		
		public String getDe() {
			return de;
		}
		
		public String getIt() {
			return it;
		}
	}
}
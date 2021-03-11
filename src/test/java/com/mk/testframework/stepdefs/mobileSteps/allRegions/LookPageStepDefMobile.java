package com.mk.testframework.stepdefs.mobileSteps.allRegions;



import com.mk.testframework.dt.util.PageUtils;
import org.junit.Assert;
import com.google.inject.Inject;
import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.page.product.MkLookPage;
import cucumber.api.java.en.And;

/**
 * @author RSingh
 *
 */
@SuppressWarnings("deprecation")
public class LookPageStepDefMobile {

  
    private Context context;
 private MkLookPage mkLookPage;

 private PageUtils pageUtils;
 

    @Inject
    public LookPageStepDefMobile( Context context, MkLookPage mkLookPage, PageUtils pageUtils) {
        
        this.context = context;
        this.mkLookPage = mkLookPage;
       
        this.pageUtils = pageUtils;
        
    }
    
    @And("Look: I get the look product count")
    public void look_product_count() {
    int lookProductCount = mkLookPage.getlookProductCount();
    context.setLookProductCount(lookProductCount);
      
    }
    
    @And("Look: I click on buy all button")
    public void click_on_buy_all_button() {
     mkLookPage.clickOnBuyAll();
    }
    
    @And("Look: I verify Shop this look window pop us is displayed")
    public void Shop_this_look_window_is_displayed() {
     mkLookPage.shopThisLook();
    
    }
    
    @And("Look: Add all the items to bag")
    public void Add_all_the_items_to_bag() throws InterruptedException {
     mkLookPage.addallLookItemsToBag();
     Thread.sleep(10000);
     pageUtils.waitForPageToLoad();
     
     
     
    }
    
    @And("Look: I check the product count in basket")
 public void productCountinBasket() 
 {
     
  int actual= mkLookPage.getlookProductCountInBasket();
  int expected=context.getLookProductCount();
  Assert.assertEquals(expected, actual);
    }
}
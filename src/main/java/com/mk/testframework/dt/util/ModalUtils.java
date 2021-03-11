package com.mk.testframework.dt.util;

import com.mk.testframework.core.env.Context;
import com.mk.testframework.dt.popup.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

/**
 * @author VThipperudrappa
 *
 */
public class ModalUtils {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private MkCountryChangePopup mkCountryChangePopup;
	private MkKorsVIPModal mkKorsVIPModal;
	private MkStayInTouchModal mkStayInTouchModal;
	private MkKorsVIPSignupModal mkKorsVIPSignupModal;
	private MkNeverMissABeatModal mkNeverMissABeatModal;
	private MkZipCodePopup mkZipCodePopup;
	private Context context;
	private PageUtils pageUtils;

	@Inject
	public ModalUtils(MkCountryChangePopup mkCountryChangePopup, MkKorsVIPModal mkKorsVIPModal,
					  MkStayInTouchModal mkStayInTouchModal, MkKorsVIPSignupModal mkKorsVIPSignupModal,
					  MkNeverMissABeatModal mkNeverMissABeatModal,
					  MkZipCodePopup mkZipCodePopup, Context context, PageUtils pageUtils) {
this.mkCountryChangePopup = mkCountryChangePopup;
		this.mkKorsVIPModal = mkKorsVIPModal;
		this.mkStayInTouchModal = mkStayInTouchModal;
		this.mkKorsVIPSignupModal = mkKorsVIPSignupModal;
		this.mkNeverMissABeatModal = mkNeverMissABeatModal;
		this.mkZipCodePopup = mkZipCodePopup;
		this.context = context;
		this.pageUtils =pageUtils;

	}

	public void closeNeverMissABeatPopupIfPresented() {
		if (mkNeverMissABeatModal.waitForNeverMissABeatModal()) {
			log.info("Closing Promo signup popup");
			mkNeverMissABeatModal.close();
            context.setpopUpDismissedStatus(true);
		}
	}

	public void closeKorsVipModalIfPresented() {
		if (mkKorsVIPModal.waitForKorsVIPModal()) {
			log.info("Closing Kors VIP modal");
			mkKorsVIPModal.close();
            context.setpopUpDismissedStatus(true);
		}
	}

	public void acceptCountryChangePopupIfPresented() {
		if (mkCountryChangePopup.waitForCountryChangeDialog()) {
			log.info("Accepting country change dialog");
			mkCountryChangePopup.acceptCountryChange();
			context.writeOut("Accepted country change popup");
			context.setChangeCountryPopUpDismissedStatus(true);
		}
//		} else {
//			log.info("mkCountryChangePopup Not displayed retrying for second time");
//			pageUtils.deleteAllCookies();
//			pageUtils.sleepSeconds(5, null);
//			mkCountryChangePopup.acceptCookieBannerIfPresented();
//			if (mkCountryChangePopup.waitForCountryChangeDialog()) {
//				log.info("Accepting mkCountryChangePopup 2nd time");
//				mkCountryChangePopup.acceptCountryChange();
//				context.writeOut("Accepting mkCountryChangePopup 2nd time");
//				context.setChangeCountryPopUpDismissedStatus(true);
//			}else{ 
//				log.info("mkCountryChangePopup Not displayed retrying for third time");
//				//pageUtils.deleteAllCookies();
//				pageUtils.sleepSeconds(5, null);
//				mkCountryChangePopup.acceptCookieBannerIfPresented();
//				if (mkCountryChangePopup.waitForCountryChangeDialog()) {
//					log.info("Accepting mkCountryChangePopup 3rd time");
//					mkCountryChangePopup.acceptCountryChange();
//					context.writeOut("Accepting mkCountryChangePopup 2nd time");
//					context.setChangeCountryPopUpDismissedStatus(true);
//				}
//			}
//		}
	}
		
	public void closeStayInTouchModalIfPresented() {
		if (mkStayInTouchModal.waitForStayInTouchModal()) {
			log.info("Closing stay in touch modal");
			mkStayInTouchModal.close();
			context.setpopUpDismissedStatus(true);
		}else {
		log.info("Stay in touch modal not dismissed trying second time");
		if (mkStayInTouchModal.waitForStayInTouchModal()) {
			pageUtils.sleepSeconds(3, "Wait for country change popup");
			log.info("Closing stay in touch modal");
			mkStayInTouchModal.close();
			context.setpopUpDismissedStatus(true);
		}else {
			log.info("Stay in touch modal not dismissed second time also");
		}
		
		}
	}

	public void closeKorsVIPFlashNoticeModalIfPresented() {
		if (mkKorsVIPSignupModal.waitForKorsVIPSignupModalModal()) {
			log.info("Closing KorsVIP signup modal");
			mkKorsVIPSignupModal.close();
		}
	}

	public void closeZipCodePopupIfPresented() {
		if (mkZipCodePopup.waitForZipCodePopup()) {
			log.info("Closing zip code popup");
			mkZipCodePopup.close();
		}
	}
	
	
}

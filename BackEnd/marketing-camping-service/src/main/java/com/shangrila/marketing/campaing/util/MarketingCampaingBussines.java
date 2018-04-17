package com.shangrila.marketing.campaing.util;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangrila.marketing.campaing.model.Campaing;
import com.shangrila.marketing.campaing.service.MarkectingCampaingService;

@Component
public class MarketingCampaingBussines {
	@Autowired
	private MarkectingCampaingService service;

	public int indexedBinarySearch(List<Campaing> l, Campaing key) {
		int low = 0;
		int high = l.size();

		while (low <= high) {
			int mid = (low + high) / 2;
			Campaing midVal = l.get(mid);
			int cmp = midVal.getDateEndCampaing().compareTo(key.getDateEndCampaing());
			if (cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else {
				if (midVal.getDateStartCampaing().isEqual(key.getDateStartCampaing())) {
					atualizadata(l);
				}
				indexedBinarySearch(l, key);
			}
		}
		return -(low + 1); // key not found
	}

	private void atualizadata(List<Campaing> l) {
		for (int i = 0; i < l.size(); i++) {
			LocalDate dateEnd = l.get(i).getDateEndCampaing();
			l.get(i).setDateEndCampaing(dateEnd.plusDays(1));
			service.save(l.get(i));
		}
	}

}

package com.pst.tags;

import org.apache.commons.lang.BooleanUtils;

public class CustomFunctions {

	public static String displayMappingSource(Boolean yesOrNo) {
		return BooleanUtils.toBooleanDefaultIfNull(yesOrNo, false) ? "Yes!" : "No.";
	}
	
}

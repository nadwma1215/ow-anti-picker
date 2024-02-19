package com.example.demo.form.anti_pick;



import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * ヒーロー追加 Form
 */
@Data
public class AntiPickListForm {

	private Map<Integer, List<Integer>> heroIdMap;

}

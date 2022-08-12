package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Comparator;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;
//import com.kh.practice.list.music.model.compare.AscTitle;

public class MusicController {
	List<Music> list = new ArrayList<Music>();

	public MusicController() {
		list.add(new Music("Thas's Hilarious", "Charlie Puth"));
		list.add(new Music("Antifreeze", "백예린"));
		list.add(new Music("Feel My Rhythm", "레드벨벳"));
		list.add(new Music("Sunflower", "PostMalon,Swae Lee"));
		list.add(new Music("ZZZZ", "AAAA"));
		list.add(new Music("ZZZZ", "ZZZZ"));
		// 테스트용 데이터
	}

	public int addList(Music music) {
		for (Music m : list) {
			if (m.equals(music)) { // 리스트에 일치하는 곡이있으면 추가 실패
				return 0;
			}
		}
		list.add(music);
		return 1;
	}

	public int addAtZero(Music music) {
		for (Music m : list) {
			if (m.equals(music)) { // 리스트에 일치하는 곡이있으면 추가 실패
				return 0;
			}
		}
		list.add(0, music);
		return 1;
	}

	public List printAll() {
		return list;
	}

	public Music searchMusic(String title) {
		Music result = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				result = list.get(i);
				break;
			}
		}
		return result;
	}

	public Music removeMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.remove(i);//이경우 무조건
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		Music result = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				result = list.get(i);
				list.set(i, music);
				break;
			}
		}
		return result;
	}

	public void ascTitle() {
		list.sort(Comparator.naturalOrder());
		
	}

	public void descTitle() {
		AscTitle at=new AscTitle();
		Collections.sort(list,at);;
	}

}

package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;


public class AscTitle implements Comparator<Music>{
	@Override
	public int compare(Music o1, Music o2) {
		// TODO Auto-generated method stub
		return o2.getSinger().charAt(0)-o1.getSinger().charAt(0);
	}
}

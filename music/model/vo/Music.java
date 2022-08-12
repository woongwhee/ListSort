package com.kh.practice.list.music.model.vo;

import java.util.Comparator;

public class Music implements Comparable<Music>{
	private String title;
	private String singer;

	public Music() {
	}

	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return title + "-" + singer;
	}
	@Override
	public int compareTo(Music o) {
//		Music m=(Music)o;	
		return this.title.compareTo(o.title);
	}
	@Override
	public boolean equals(Object o) {
		if(this==o){return true;}
		if(o==null){return false;}
		if(!(o instanceof Music)) {	return false;}
		Music m=(Music)o;
		if(m.title==null||!(title.equals(m.title))) {
			return false;
		}
		if(m.singer==null||!(singer.equals(m.singer))) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		return title.hashCode()+singer.hashCode();
		
	}

//	@Override
//	public int compare(Object o1, Object o2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}

package com.kh.practice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. 마지막 위치에 곡 추가 ");
			System.out.println("2. 첫 위치에 곡 추가  ");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.다시입력해 주세요");
			}

		}
	}

	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");

		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();

		int result = mc.addList(new Music(title, singer));
		if (result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패,이미 일치하는 곡이 있습니다.");
		}
	}

	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");

		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print ("가수 명 : ");
		String singer = sc.nextLine();

		int result = mc.addAtZero(new Music(title, singer));
		if (result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패,이미 일치하는 곡이 있습니다.");
		}
	}

	public void printAll() {
		List<Music> list = mc.printAll();
		System.out.print("****** 전체 곡 목록 출력 ******\n[");
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1) {
				System.out.print(list.get(i) + ",");
			} else {
				System.out.print(list.get(i)+ "]\n");
			}
		}
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 :");
		String title = sc.nextLine();
		Music music = mc.searchMusic(title);
		if (music != null) {
			System.out.println(music);
		} else {
			System.out.println("일치하는 곡이 없습니다.");
		}

	}

	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 :");
		String title = sc.nextLine();
		Music music = mc.removeMusic(title);
		if (music != null) {
			System.out.println(music+"을(를) 삭제했습니다.");
		} else {
			System.out.println("일치하는 곡이 없습니다.");
		}
	}

	public void setMusic() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡 명 :");
		String title = sc.nextLine();
		System.out.print("수정할 곡 명 :");
		String newTitle = sc.nextLine();
		System.out.print("수정할 가수 명 :");
		String newSinger = sc.nextLine();
		Music music =new Music(newTitle,newSinger);
		Music result = mc.setMusic(title, music);
		if(result!=null) {
			System.out.println(result+"의 값이 수정되었습니다."); 
		}
	}

	public void ascTitle() {
		mc.ascTitle();
		System.out.println("정렬성공");
	}

	public void descSinger() {
		mc.descTitle();
		System.out.println("정렬성공");
	}

}

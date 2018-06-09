package MindMap;

import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Controller extends MouseAdapter implements MouseListener{
	
	ShapeParent v;
	Shape s;
	JPanel p;
	Color c;
	
	String fileName = "", getJsonString= "";
	
	private ArrayList<Model> m_list = new ArrayList<Model>();
	
	Controller(){
		
	}
	
	public int Size() {
		return m_list.size();
	}
	
	//Get Method
	public int getX(int index) {
		return m_list.get(index).x;
	}
	
	public int getY(int index) {
		return m_list.get(index).y;
	}
	
	public int getX2(int index) {
		return m_list.get(index).x2;
	}
	
	public int getY2(int index) {
		return m_list.get(index).y2;
	}
	
	public int getW(int index) {
		return m_list.get(index).w;
	}
	
	public int getH(int index) {
		return m_list.get(index).h;
	}
	
	public String getTitle(int index) {
		return m_list.get(index).title;
	}
	
	public int getColor(int index) {
		return m_list.get(index).color;
	}
	
	//Set Method
	
	public void setX(int index, int x) {
		m_list.get(index).x = x;
		getDraw();
	}
	
	public void setY(int index, int y) {
		m_list.get(index).y = y;
		getDraw();
	}
	
	public void setX2(int index, int x2) {
		m_list.get(index).x2 = x2;
		getDraw();
	}
	
	public void setY2(int index, int y2) {
		m_list.get(index).y2 = y2;
		getDraw();
	}
	
	public void setW(int index, int w) {
		m_list.get(index).w = w;
		getDraw();
	}
	
	public void setH(int index, int h) {
		m_list.get(index).h = h;
		getDraw();
	}
	
	public void setTitle(int index, String title) {
		m_list.get(index).title = title;
		getDraw();
	}
	
	public void setColor(int index, int color) {
		m_list.get(index).color = color;
		getDraw();
	}
	
	//change model
	
	//저장된 도형을 모조리 없애기 - 새로 만들기 시
	public void removeAllList() {
		m_list.removeAll(m_list);
	}
	
	//해당 index값의 노드 삭제
	public void removeList(int index) {
		m_list.remove(index);
		getDraw();
	}
	
	//도형 추가
	public void addList(int x, int y, int x2, int y2, String title, int color) {
		Model m = new Model(x, y, x2, y2, title, color);
		m_list.add(m);
		getDraw();
	}
	
	//도형 속성 변경
	public void changeList(int index, int x, int y, int x2, int y2, int w, int h, String title, int color) {
		m_list.get(index).x = x;
		m_list.get(index).y = y;
		m_list.get(index).w = w;
		m_list.get(index).h = h;
		m_list.get(index).title = title;
		m_list.get(index).color = color;
		getDraw();
	}
	
	//m_list에 들어있는 Model객체의 color 변수의 값에 따라 색깔 리
	private Color getC(int color) {
		c = new Color(color);
		return c;
	}
	

	private void getDraw() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

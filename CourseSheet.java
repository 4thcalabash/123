package courseSheet;
import javax.swing.*;
import java.awt.event.*;
//import java.util.ArrayList;
public class CourseSheet {
	private Sheet sheet;
	private JFrame frame;
	private Mypanel panel;
		
	public CourseSheet(){
		sheet = new Sheet(panel);	
	}
	
	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public static void main(String args[]){
		CourseSheet coursesheet = new CourseSheet ();
//		coursesheet.sheet = new Sheet (new Mypanel(coursesheet));
		coursesheet.go(coursesheet);
		
	}
	
	public class AddActionListener implements ActionListener{
		private CourseSheet coursesheet;
		public AddActionListener(CourseSheet coursesheet){
			this.coursesheet = coursesheet;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddCourseInputDialog(coursesheet).setVisible(true);
		} 
		
		
	}
	
	public class DeleteActionListener implements ActionListener{
		private CourseSheet coursesheet;
		public DeleteActionListener (CourseSheet coursesheet){
			this.coursesheet=coursesheet;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new DeleteCourseInputDialog(coursesheet).setVisible(true);
		}
	}
	
	
	public void go(CourseSheet coursesheet){
		frame = new JFrame("CourseSheet");
//		panel = this.sheet.getPanel();
		panel = new Mypanel(coursesheet);
		this.sheet = new Sheet (panel);
//		frame.setLayout(null);
		panel.setSize(1200,600);
		frame.add(panel);
//		panel.setLocation(25,35);	
		frame.setLayout(null);
		frame.add(panel);
		JButton Add = new JButton ("ADD");
		Add.setSize(80, 40);
		Add.setLocation(600,20);
		Add.addActionListener(new AddActionListener (coursesheet));
		JButton Delete = new JButton ("DELETE");
		Delete.setSize(80,40);
		Delete.setLocation(600,70);
		Delete.addActionListener(new DeleteActionListener (coursesheet));
		frame.add(Add);
		frame.add(Delete);
		frame.setSize(700, 700);
		frame.setVisible(true);

	}
	
}

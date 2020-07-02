package pip.Selenium.Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDemo implements ActionListener {

	JLabel url;
	JTextField urlField;
	JButton button;
	
	public void browserInput() {
		
		
		
		JFrame f = new JFrame();
		url = new JLabel("Enter URL");
		url.setBounds(10, 10, 300, 30);
		urlField = new JTextField();
		urlField.setBounds(150, 10, 300, 30);
		
		button = new JButton("click");
		button.setBounds(150, 200, 100, 40);
		button.addActionListener(this);
		f.add(url);
		f.add(urlField);
		f.add(button);
		f.setSize(700, 500);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String baseUrl = urlField.getText(); 
		if (e.getSource() == button) {

			try {
				urlOpen(baseUrl);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void urlOpen(String baseUrl) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "E:\\DOCS\\ChromeDriver_83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String title=driver.getTitle();
		String security = "https://www.";
		if(baseUrl.contains(security))
			driver.get(baseUrl);
		else
		{
			String baseUrlwithSecurity=security.concat(baseUrl);
			driver.get(baseUrlwithSecurity);
		}
		//driver.get("https://www.fb.com");
		
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		System.out.println(title);
//		if(title!="Google") {
//			System.out.println("Wrong window");
			driver.quit();
			
		//}
			
			
		

	}

}

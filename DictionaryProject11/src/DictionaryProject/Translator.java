package DictionaryProject;

import javax.swing.*;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class Translator extends JFrame implements ActionListener {

	JTextArea leftTextArea;
    JComboBox<String> translationOptions;
    private JTextArea rightTextArea;
    
    boolean isEngToTurkish = true;
    
    MyDictionary dictionary;
    
    private JButton btnNewButton;

    Translator() {
    	dictionary = new MyDictionary();
    	
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\Downloads\\translate.png"));
    	getContentPane().setBackground(Color.GRAY);
        setTitle("Translator App");
        setSize(672, 597);

        String[] options = {"English-Turkish", "Turkish-English"};
        translationOptions = new JComboBox<>(options);
        translationOptions.setBackground(new Color(102, 153, 204));
        translationOptions.setForeground(new Color(0, 0, 0));
        translationOptions.setFont(new Font("Century Gothic", Font.ITALIC, 22));
        translationOptions.setBounds(233, 22, 180, 43);
        getContentPane().add(translationOptions);

        leftTextArea = new JTextArea();
        leftTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        leftTextArea.setLineWrap(true);
        leftTextArea.setBounds(50, 84, 249, 312);
        getContentPane().add(leftTextArea);

        translationOptions.addActionListener(this);

        getContentPane().setLayout(null);
        
        rightTextArea = new JTextArea();
        rightTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        rightTextArea.setLineWrap(true);
        rightTextArea.setBounds(369, 84, 249, 312);
        getContentPane().add(rightTextArea);
        
        btnNewButton = new JButton("Go!");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String turkishWord=null;
				String english=null;
				
				System.out.println("Buton Click lendi");
				
				
				if(isEngToTurkish) {				
					english = leftTextArea.getText();
					turkishWord = dictionary.mapping.fromEnglish(english, dictionary.getEnglishWords);
					
					if (turkishWord != null) {
						rightTextArea.setText(turkishWord);
					}
					else {
						rightTextArea.setText("Kelime bulunamadi!");
					}
				}
				else {
					turkishWord = leftTextArea.getText();
					english = dictionary.mapping.fromTurkish(turkishWord, dictionary.getTurkishWords);
					
					if (english != null) {
						rightTextArea.setText(english);
					}
					else {
						rightTextArea.setText("Kelime bulunamadi!");
					}
					
				}
				
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(264, 453, 133, 30);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\WhatsApp Image 2024-01-02 at 21.11.13_b3e2d37c.jpg"));
        lblNewLabel.setBounds(0, 0, 658, 560);
        getContentPane().add(lblNewLabel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) translationOptions.getSelectedItem();
        String textToTranslate = leftTextArea.getText();
        String translatedText = "";

        // Çeviri seçeneklerine göre tercüme yap
        if (selectedOption.equals("English-Turkish")) {
        	isEngToTurkish = true;
            translatedText = translateEnglishToTurkish(textToTranslate);
        } else if (selectedOption.equals("Turkish-English")) {
        	isEngToTurkish = false;
            translatedText = translateTurkishToEnglish(textToTranslate);
        }

        // Tercüme sonucunu sağdaki JTextArea'ya göster
        rightTextArea.setText(translatedText);
    }

    // İngilizce-Türkçe çeviri yapacak metod
    public String translateEnglishToTurkish(String englishText) {
        // Buraya İngilizce-Türkçe çeviri algoritması eklenecek
        // Örnek olarak, gelen İngilizce kelimenin Türkçe karşılığını döndüren geçici bir kod
        return "Türkçe çevirisi buraya gelecek";
    }

    // Türkçe-İngilizce çeviri yapacak metod
    public String translateTurkishToEnglish(String turkishText) {
        // Buraya Türkçe-İngilizce çeviri algoritması eklenecek
        // Örnek olarak, gelen Türkçe kelimenin İngilizce karşılığını döndüren geçici bir kod
        return "English translation will be here";
    }
}

package com.gmail.st1tchqwerty;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.io.BufferedReader;

public class GroupFileStorage {
	

	void saveGroupToCSV(Group gr)throws IOException {
		FileWriter writer = new FileWriter(gr.getName() + ".csv");
		for (int i = 0; i < gr.getStudents().length; i++) {
			try {
				String str = gr.getStudents()[i].toCSVString()+"\n";
				writer.append(str);
			} catch (Exception e) {
				break;
			}
			}
		writer.close();
		}
	
		Group loadGroupFromCSV(File file) {
			Group gr = new Group();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine;
			String[] studs = new String[gr.getStudents().length];
			for (int i = 0; i < studs.length; i++) {
				currentLine = reader.readLine();
				if (!Objects.isNull(currentLine))
					studs[i] = currentLine;
				else
					break;
			}
			for (int i = 0; i < studs.length; i++) {
				String[] splittedString = studs[i].split(";");
				String name = splittedString[0];
				String surname = splittedString[1];
				String age = splittedString[2];
				String grade=splittedString[3];
				String specialization=splittedString[4];
				Student stud=new Student(Integer.parseInt(age), surname, name, Integer.parseInt(grade), specialization);
				gr.add(stud);
			}
			return gr;
		}
	
		File findFileByGroupName(String groupName, File workFolder) {
			File[] list = workFolder.listFiles();
			groupName += ".csv";
			if (list != null) {
				for (File f : list) {
					if (f.isFile())
						if (groupName.equals(f.getName())) {
							return f;
						}
				}
			}
			return null;
		}
		}

}

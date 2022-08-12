package CSV.ReadWrite;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class OpenCSVWriter {
    private static final String STRING_ARRAY_SAMPLE = "C:\\Users\\lisad\\TerminalCommands\\Java\\ReadWrite\\WriteonCSVList.csv";

    public static void main(String[] args) throws IOException {
        try (
            Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

//            CSVWriter csvWriter = new CSVWriter(writer,
//                    CSVWriter.DEFAULT_SEPARATOR,
//                    CSVWriter.NO_QUOTE_CHARACTER,
//                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
//                    CSVWriter.DEFAULT_LINE_END);
//        ) {
//            String[] headerRecord = {"Name", "Email", "Phone", "Country"};
//            csvWriter.writeNext(headerRecord);
//
//            csvWriter.writeNext(new String[]{"Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111", "India"});
//            csvWriter.writeNext(new String[]{"Satya Nadella", "satya.nadella@outlook.com", "+1-1111111112", "India"});
        		
        		
        		) {
            StatefulBeanToCsv<MyUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<MyUser> myUsers = new ArrayList<>();
            myUsers.add(new MyUser("Lisa", "lisa.pichai@gmail.com", "+1-1111111111", "India"));
            myUsers.add(new MyUser("Riya", "riya.nadella@outlook.com", "+1-1111111112", "India"));

            beanToCsv.write(myUsers);
        		
        } catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("All data has been added to CSV file");
        
    }
}
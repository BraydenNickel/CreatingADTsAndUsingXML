package parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.project.classes.*;

public class XMLParser {

	public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java XmlParser <xml_file_path>");
            return;
        }

        String filePath = args[0];
        try {
            parseXmlFile(filePath);
        } catch (IOException e) {
            System.out.println("Error reading the XML file: " + e.getMessage());
        }
    }

    private static void parseXmlFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            MyStack<String> tagStack = new MyStack<>();
            MyQueue<String> errorQueue = new MyQueue<>();
            MyQueue<String> extrasQueue = new MyQueue<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (isProcessingInstruction(line) || isSelfClosingTag(line)) {
                    // Ignore processing instructions and self-closing tags
                    continue;
                }

                String tagName = getTagName(line);

                if (isStartTag(line)) {
                    tagStack.push(tagName);
                } else if (isEndTag(line)) {
                    if (!tagStack.isEmpty() && tagName.equals(tagStack.peek())) {
                        tagStack.pop();
                    } else if (!errorQueue.isEmpty() && tagName.equals(errorQueue.peek())) {
                        errorQueue.dequeue();
                    } else if (tagStack.isEmpty()) {
                        errorQueue.enqueue(tagName);
                    } else {
                        // Search for a matching start tag in the stack
                        MyStack<String> tempStack = new MyStack<>();
                        while (!tagStack.isEmpty()) {
                            String poppedTag = tagStack.pop();
                            extrasQueue.enqueue(poppedTag);
                            if (tagName.equals(poppedTag)) {
                                break;
                            }
                            tempStack.push(poppedTag);
                        }

                        // Report as an error
                        while (!tempStack.isEmpty()) {
                            errorQueue.enqueue(tempStack.pop());
                        }
                    }
                }
            }

            // Pop remaining tags into errorQueue
            while (!tagStack.isEmpty()) {
                errorQueue.enqueue(tagStack.pop());
            }

            // Report errors
            while (!errorQueue.isEmpty()) {
                System.out.println("Error: " + errorQueue.dequeue());
            }

            // Report extras
            while (!extrasQueue.isEmpty()) {
                System.out.println("Extra tag: " + extrasQueue.dequeue());
            }
        }
    }

    private static boolean isProcessingInstruction(String line) {
        return line.trim().startsWith("<?xml");
    }

    private static boolean isStartTag(String line) {
        return line.trim().matches("^\\s*<[^/].*>\\s*$");
    }

    private static boolean isEndTag(String line) {
        return line.trim().matches("^\\s*</[^/].*>\\s*$");
    }

    private static boolean isSelfClosingTag(String line) {
        return line.trim().matches("^\\s*<[^/].*/>\\s*$");
    }

    private static String getTagName(String line) {
        String trimmedLine = line.trim();
        int startIndex = trimmedLine.indexOf('<') + 1;
        int endIndex = trimmedLine.indexOf('>');
        return trimmedLine.substring(startIndex, endIndex).split(" ")[0];
    }
}
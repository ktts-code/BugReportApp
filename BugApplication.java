package com.company;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BugApplication {
    public static void main(String[] args) {

        UniqePriorityQueue bugs = new UniqePriorityQueue();

        bugs.addUnique( new Bug("User registration gives warning", "Kolyan", 1, 2), bugs );
        bugs.addUnique( new Bug("User cant login", "Vovan", 5,10), bugs );
        bugs.addUnique( new Bug("User cant upload avatar", "Masha", 2,4), bugs );
        bugs.addUnique( new Bug("Test bug", "Dasha", 1,1), bugs );
        bugs.addUnique( Bug.addBug(), bugs );

        Bug b;
        while( (b = bugs.poll()) != null ){
            System.out.println( b );
        }
    }
}

class UniqePriorityQueue extends PriorityQueue<Bug>{

    public boolean addUnique(Bug b, UniqePriorityQueue bugs){
        for ( Bug x : bugs )
        {
            if( b.getTitle().equals(x.getTitle() )){
                System.err.println("Sorry, this bug already exist in a system!");
                return false;
            }
        }
        this.add(b);
        return false;
    }
}

class Bug implements Comparable<Bug>{
    private String title;
    private String author;
    private Integer priority;
    private Integer severity;


    public Bug(String title, String author, Integer severity, Integer priority) {
        super();
        setTitle(title);
        setAuthor(author);
        setSeverity(severity);
        setPriority(priority);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public Integer getSeverity() { return severity; }
    public void setSeverity(Integer severity) { if(severity>0 && severity<=5)
    { this.severity = severity; }else{ System.err.println("Incorrect severity value!"); return; } }
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { if(priority>0 && priority<=10)
    { this.priority = priority; }else{ System.err.println("Incorrect priority value!"); return; } }

    @Override
    public String toString() { return "\nBug: " + title + ", author: " + author + ", severity: " + severity + ", priority: " + priority; }

    @Override
    public int compareTo( Bug o) { return o.priority - this.priority; }

    public static Bug addBug(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please write down new bug TITLE");
        String new_title = in.nextLine();
        System.out.println("Please select AUTHOR");
        String new_author = in.nextLine();
        System.out.println("Please select SEVERITY from 1 to 5");
        int new_severity = in.nextInt();
        System.out.println("Please select PRIORITY from 1 to 10");
        int new_priority = in.nextInt();
        return new Bug(new_title,new_author,new_severity,new_priority);
    }

}

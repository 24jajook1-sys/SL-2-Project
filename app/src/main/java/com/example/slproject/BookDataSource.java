package com.example.slproject;

import java.util.ArrayList;
import java.util.List;

public class BookDataSource {

    public static List<Book> getBooksForCategory(String category) {
        List<Book> books = new ArrayList<>();

        switch (category) {

            case "Novel":
                books.add(new Book("The Alchemist", "Paulo Coelho", "Novel",
                        "A philosophical novel about a young shepherd's journey to find treasure. A timeless masterpiece of self-discovery.", R.drawable.ic_book));
                books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Novel",
                        "A gripping story of racial injustice and childhood innocence in the American South. Pulitzer Prize winner.", R.drawable.ic_book));
                books.add(new Book("1984", "George Orwell", "Novel",
                        "A dystopian social science fiction novel about a totalitarian society. A chilling vision of the future.", R.drawable.ic_book));
                books.add(new Book("Harry Potter & the Philosopher's Stone", "J.K. Rowling", "Novel",
                        "The magical journey of a young wizard discovering his destiny at Hogwarts School of Witchcraft and Wizardry.", R.drawable.ic_book));
                books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel",
                        "A classic American novel set in the Jazz Age about love, wealth, and the American Dream.", R.drawable.ic_book));
                books.add(new Book("Pride and Prejudice", "Jane Austen", "Novel",
                        "A romantic novel about Elizabeth Bennet and Mr. Darcy navigating manners, morality, and marriage.", R.drawable.ic_book));
                books.add(new Book("The Kite Runner", "Khaled Hosseini", "Novel",
                        "A powerful story of friendship, betrayal, and redemption set against the backdrop of Afghanistan.", R.drawable.ic_book));
                books.add(new Book("Midnight's Children", "Salman Rushdie", "Novel",
                        "A magical realist novel about India's transition from British colonialism to independence and beyond.", R.drawable.ic_book));
                books.add(new Book("The God of Small Things", "Arundhati Roy", "Novel",
                        "A Booker Prize winning novel exploring forbidden love and social taboos in Kerala, India.", R.drawable.ic_book));
                books.add(new Book("Five Point Someone", "Chetan Bhagat", "Novel",
                        "A fun read about three friends at IIT Delhi struggling with academics, life, and friendship.", R.drawable.ic_book));
                break;

            case "Autobiography":
                books.add(new Book("My Experiments with Truth", "Mahatma Gandhi", "Autobiography",
                        "The autobiography of Mohandas Karamchand Gandhi, describing his experiments in pursuit of truth and nonviolence.", R.drawable.ic_book));
                books.add(new Book("Winning Doesn't Come Easy", "MS Dhoni", "Autobiography",
                        "The inspiring life story of Mahendra Singh Dhoni — from Ranchi to becoming India's greatest captain.", R.drawable.ic_book));
                books.add(new Book("Wings of Fire", "APJ Abdul Kalam", "Autobiography",
                        "The inspiring autobiography of India's Missile Man and former President, Dr. APJ Abdul Kalam.", R.drawable.ic_book));
                books.add(new Book("Long Walk to Freedom", "Nelson Mandela", "Autobiography",
                        "Nelson Mandela's account of his childhood, education, and 27-year imprisonment, and his journey to freedom.", R.drawable.ic_book));
                books.add(new Book("The Story of My Life", "Helen Keller", "Autobiography",
                        "Helen Keller's remarkable autobiography about overcoming blindness and deafness to become a world-famous author.", R.drawable.ic_book));
                books.add(new Book("Playing It My Way", "Sachin Tendulkar", "Autobiography",
                        "The Master Blaster's journey from a young boy in Mumbai to becoming the greatest batsman of all time.", R.drawable.ic_book));
                books.add(new Book("I Am Malala", "Malala Yousafzai", "Autobiography",
                        "The courageous story of Malala Yousafzai, who stood up for education and survived a Taliban assassination attempt.", R.drawable.ic_book));
                books.add(new Book("An Unfinished Life", "John F. Kennedy", "Autobiography",
                        "A detailed biography covering the life and presidency of the 35th President of the United States.", R.drawable.ic_book));
                books.add(new Book("Agni Ki Udaan", "APJ Abdul Kalam", "Autobiography",
                        "The Hindi version of Wings of Fire — capturing the extraordinary life of Dr. Kalam in his mother tongue.", R.drawable.ic_book));
                books.add(new Book("The Test of My Life", "Yuvraj Singh", "Autobiography",
                        "Yuvraj Singh's inspiring story of battling cancer and making a triumphant comeback to cricket.", R.drawable.ic_book));
                break;

            case "Engineering College":
                books.add(new Book("Data Structures & Algorithms", "Narasimha Karumanchi", "Engineering",
                        "A comprehensive guide to data structures, algorithms, and problem-solving techniques for engineering students.", R.drawable.ic_book));
                books.add(new Book("Engineering Mathematics Vol. 1", "H.K. Dass", "Engineering",
                        "Covers calculus, differential equations, and linear algebra essential for all engineering branches.", R.drawable.ic_book));
                books.add(new Book("Object Oriented Programming in C++", "E. Balagurusamy", "Engineering",
                        "A classic textbook for learning Object-Oriented Programming concepts using C++ language.", R.drawable.ic_book));
                books.add(new Book("Database Management Systems", "Ramakrishnan & Gehrke", "Engineering",
                        "A complete reference for DBMS concepts including SQL, normalization, and transaction management.", R.drawable.ic_book));
                books.add(new Book("Computer Networks", "Andrew S. Tanenbaum", "Engineering",
                        "The definitive textbook on computer networks covering OSI model, TCP/IP, and network protocols.", R.drawable.ic_book));
                books.add(new Book("Operating System Concepts", "Silberschatz, Galvin & Gagne", "Engineering",
                        "The 'Dinosaur Book' — a standard OS textbook covering process management, memory, and file systems.", R.drawable.ic_book));
                books.add(new Book("Engineering Physics", "S.K. Gupta", "Engineering",
                        "Fundamental physics for engineering students covering optics, quantum mechanics, and thermodynamics.", R.drawable.ic_book));
                books.add(new Book("Electrical Engineering Fundamentals", "Vincent Del Toro", "Engineering",
                        "Comprehensive coverage of electrical circuits, machines, and electronics for engineering students.", R.drawable.ic_book));
                books.add(new Book("Strength of Materials", "R.K. Bansal", "Engineering",
                        "Essential reading for mechanical and civil engineering students on stress, strain, and structural analysis.", R.drawable.ic_book));
                books.add(new Book("Artificial Intelligence", "Russell & Norvig", "Engineering",
                        "The bible of AI — covering search algorithms, knowledge representation, machine learning, and robotics.", R.drawable.ic_book));
                break;

            case "NEET Books":
                books.add(new Book("NCERT Biology Class 11 & 12", "NCERT", "NEET",
                        "The foundational biology textbook for NEET aspirants — covers all chapters asked in the exam.", R.drawable.ic_book));
                books.add(new Book("Objective Biology", "Dinesh", "NEET",
                        "A comprehensive objective biology book with MCQs topic-wise for NEET preparation.", R.drawable.ic_book));
                books.add(new Book("NCERT Chemistry Part 1 & 2", "NCERT", "NEET",
                        "Standard chemistry textbooks for NEET covering organic, inorganic, and physical chemistry.", R.drawable.ic_book));
                books.add(new Book("Physical Chemistry for NEET", "O.P. Tandon", "NEET",
                        "A detailed guide to physical chemistry concepts with solved examples and practice questions.", R.drawable.ic_book));
                books.add(new Book("NCERT Physics Class 11 & 12", "NCERT", "NEET",
                        "Essential physics textbooks covering mechanics, optics, electricity, and modern physics for NEET.", R.drawable.ic_book));
                books.add(new Book("Concepts of Physics", "H.C. Verma", "NEET",
                        "A popular physics book among NEET aspirants with deep conceptual clarity and problem sets.", R.drawable.ic_book));
                books.add(new Book("33 Years NEET Solved Papers", "Arihant Experts", "NEET",
                        "Collection of 33 years of NEET/AIPMT previous year papers with detailed solutions.", R.drawable.ic_book));
                books.add(new Book("Trueman's Elementary Biology", "K.N. Bhatia", "NEET",
                        "A trusted biology reference for NEET with clear diagrams, notes, and multiple-choice questions.", R.drawable.ic_book));
                books.add(new Book("Organic Chemistry for NEET", "Morrison & Boyd", "NEET",
                        "Detailed organic chemistry textbook with reactions, mechanisms, and problems for NEET students.", R.drawable.ic_book));
                books.add(new Book("MTG Fingertips Biology", "MTG Editorial Board", "NEET",
                        "Quick revision biology book with important points, diagrams, and MCQs for last-minute NEET prep.", R.drawable.ic_book));
                break;

            case "JEE Books":
                books.add(new Book("Problems in General Physics", "I.E. Irodov", "JEE",
                        "A classic collection of challenging physics problems used by top JEE Advanced aspirants worldwide.", R.drawable.ic_book));
                books.add(new Book("Concepts of Physics Vol. 1 & 2", "H.C. Verma", "JEE",
                        "The most popular physics book for JEE preparation — clear concepts and excellent problem sets.", R.drawable.ic_book));
                books.add(new Book("Mathematics for IIT JEE", "S.L. Loney", "JEE",
                        "Covers trigonometry and coordinate geometry with rigorous problems for JEE Main and Advanced.", R.drawable.ic_book));
                books.add(new Book("Organic Chemistry", "O.P. Tandon", "JEE",
                        "A comprehensive organic chemistry textbook with detailed reactions and mechanisms for JEE.", R.drawable.ic_book));
                books.add(new Book("Inorganic Chemistry", "J.D. Lee", "JEE",
                        "A thorough treatment of inorganic chemistry covering periodic properties, coordination compounds, and more.", R.drawable.ic_book));
                books.add(new Book("Higher Algebra", "Hall & Knight", "JEE",
                        "A classic higher algebra book covering progressions, permutations, combinations, and series for JEE.", R.drawable.ic_book));
                books.add(new Book("Physical Chemistry", "P. Bahadur", "JEE",
                        "Numerical and conceptual physical chemistry with extensive problems and solutions for JEE.", R.drawable.ic_book));
                books.add(new Book("Play with Graphs", "Amit M. Agarwal", "JEE",
                        "A focused book on graphical approach to functions, calculus, and transformations for JEE Advanced.", R.drawable.ic_book));
                books.add(new Book("40 Years JEE Advanced Solved Papers", "Arihant Experts", "JEE",
                        "Comprehensive solved question bank covering 40 years of IIT JEE Advanced previous year papers.", R.drawable.ic_book));
                books.add(new Book("Coordinate Geometry", "S.K. Goyal", "JEE",
                        "A JEE-focused coordinate geometry guide with theory, examples, and graded exercise sets.", R.drawable.ic_book));
                break;

            case "Motivational":
                books.add(new Book("Think and Grow Rich", "Napoleon Hill", "Motivational",
                        "One of the best-selling self-help books of all time — teaches the philosophy of success and wealth.", R.drawable.ic_book));
                books.add(new Book("The Power of Now", "Eckhart Tolle", "Motivational",
                        "A spiritual guide to enlightenment through living in the present moment and freeing from past/future.", R.drawable.ic_book));
                books.add(new Book("Atomic Habits", "James Clear", "Motivational",
                        "A practical framework for building good habits and breaking bad ones using tiny daily improvements.", R.drawable.ic_book));
                books.add(new Book("You Can Win", "Shiv Khera", "Motivational",
                        "A step-by-step guide to becoming a positive thinker and achieving excellence in life.", R.drawable.ic_book));
                books.add(new Book("The 7 Habits of Highly Effective People", "Stephen R. Covey", "Motivational",
                        "A principle-centered approach for solving personal and professional problems and achieving effectiveness.", R.drawable.ic_book));
                books.add(new Book("Rich Dad Poor Dad", "Robert T. Kiyosaki", "Motivational",
                        "Challenges the conventional wisdom about money and teaches financial literacy through two fathers' contrasting views.", R.drawable.ic_book));
                books.add(new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", "Motivational",
                        "A counterintuitive approach to living a good life by focusing on what truly matters.", R.drawable.ic_book));
                books.add(new Book("Ikigai", "Héctor García & Francesc Miralles", "Motivational",
                        "The Japanese secret to a long and happy life — finding your purpose and reason for being.", R.drawable.ic_book));
                books.add(new Book("The Monk Who Sold His Ferrari", "Robin Sharma", "Motivational",
                        "A fable about a lawyer's spiritual journey and discovery of a life of purpose and inner peace.", R.drawable.ic_book));
                books.add(new Book("Deep Work", "Cal Newport", "Motivational",
                        "Rules for focused success in a distracted world — how to master the ability to focus without distraction.", R.drawable.ic_book));
                break;
        }
        return books;
    }
}

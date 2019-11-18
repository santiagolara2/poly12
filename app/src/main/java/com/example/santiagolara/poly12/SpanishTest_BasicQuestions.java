package com.example.santiagolara.poly12;

public class SpanishTest_BasicQuestions {

    public String mQuestions[]= {
            "Hello",
            "Good morning",
            "Good afternoon",
            "Good evening/Good night",
            "How are you? (informal)",
            "How are you? (formal)",
            "What’s happening?",
            "I’m fine",
            "Thanks",
            "You’re welcome",
            "Please",
            "Good-bye",
            "I’ll see you later"
    };

    private String mChoices[][] = {
            {"Hola","¿Qué tal?","¿Cómo está usted?","Buenas noches",},
            {"De nada","Por favor","Buenos días","Gracias",},
            {"Buenas tardes","Adiós","Hola","Hasta luego",},
            {"Por favor","Hasta luego","¿Qué tal?","Buenas noches",},
            {"Buenas tardes","Buenos días","¿Cómo estás tú?","Adiós",},
            {"Hasta luego","Hola","Buenas noches","¿Cómo está usted?",},
            {"Buenos días","¿Qué tal?","Buenas tardes","¿Qué tal?",},
            {"Estoy bien","Buenos días","¿Qué tal?","Hasta luego",},
            {"¿Cómo estás tú?","Hasta luego","Gracias","Buenas tardes",},
            {"De nada","Hasta luego","Hola","¿Qué tal?",},
            {"¿Qué tal?","Buenas tardes","Por favor","Estoy bien",},
            {"¿Qué tal?","Buenos días","Hasta luego","Adiós",},
            {"Hasta luego","Hola","¿Cómo estás tú?","Buenas tardes",},
    };

    private String mCorrectAnswers[] = {
            "Hola",
            "Buenos días",
            "Buenas tardes",
            "Buenas noches",
            "¿Cómo estás tú?",
            "¿Cómo está usted?",
            "¿Qué tal?",
            "Estoy bien",
            "Gracias",
            "De nada",
            "Por favor",
            "Adiós",
            "Hasta luego",

    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}

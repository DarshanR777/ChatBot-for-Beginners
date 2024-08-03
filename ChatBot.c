// Chat bot in C programming
#include <stdio.h>    
#include <conio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>

#define MAX_INPUT_SIZE 50

int main()
{   
    char user_input[MAX_INPUT_SIZE];

    printf("Welcome to private Chat-bot\n");
    char name[15];
    printf("Enter your Name: ");
    fgets(name, sizeof(name), stdin);
    name[strcspn(name, "\n")] = 0;

    while(1)
    {
        printf("user==>");
        if (fgets(user_input, MAX_INPUT_SIZE, stdin) == NULL) {
            printf("Error reading input.\n");
            return 1;
        }

        // Remove the newline character from the end of the string
        user_input[strcspn(user_input, "\n")] = 0;


        //Exit from Bot
        if(strcmp(user_input,"exit")==0) 
        {
            printf("bot ==> Thank you so much for your time, Have a nice day %s\n",name);
            break;
        }

        else if(strcmp(user_input,"hi")==0)
        {
            printf("bot ==> Hi %s\n",name);
        }

        //Chrome
        else if(strcmp(user_input,"open chrome")==0)
        {
            printf("Opening chrome browser\n");
             system("start chrome");
        }

        //Brave
        else if(strcmp(user_input,"open brave")==0)
        {
            printf("Opening Brave\n");
             system("start Brave");
        }

        //Notepad
        else if(strcmp(user_input,"open notepad")==0)
        {
            printf("Opening notepad editor\n");
            system("start notepad");
        }

        //Command Prompt
        else if(strcmp(user_input,"open cmd")==0)
        {
            printf("Opening cmd terminal\n");
             system("start cmd");
        }

        //WordPad
        else if(strcmp(user_input,"open wordpad")==0)
        {
            printf("Opening WordPad\n");
             system("start WordPad");
        }

        //Time
        else if(strcmp(user_input,"time")==0)
        {
            time_t s, val =1 ;
            struct tm* current_time;
            //time in second
            s = time(NULL);
            current_time = localtime(&s);
            //print time in minute
            //print hour and second
            printf("bot ==> %02d:%02d:%02d\n",current_time->tm_hour,current_time->tm_min,current_time->tm_sec);
        }
        else if(strcmp(user_input,"open youtube")==0)
        {
            printf("ok sir , opening youtube\n");  
            system("start http://youtube.com");   
        }
    }
    return 0;
}

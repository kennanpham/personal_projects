#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

void simulate_loading_dance(int duration, int interval) 
{
    int end_time = duration / interval;  // Calculate total loops based on duration and interval
    for (int i = 0; i < end_time; i++) {
        printf("\rGenerating a footwork");
        for (int j = 0; j <= (i % 4); j++) {
            printf(".");
        }
        fflush(stdout);   // Flush output to ensure it updates in real-time
        usleep(interval * 1000000);  // Convert interval to microseconds for usleep
    }
    printf("\rHere is a stance sequence!\n");
}

void simulate_loading_drum(int duration, int interval) 
{
    int end_time = duration / interval;  // Calculate total loops based on duration and interval
    for (int i = 0; i < end_time; i++) {
        printf("\rGenerating a drumming sequence");
        for (int j = 0; j <= (i % 4); j++) {
            printf(".");
        }
        fflush(stdout);   // Flush output to ensure it updates in real-time
        usleep(interval * 1000000);  // Convert interval to microseconds for usleep
    }
    printf("\rHere is a drumming sequence!\n");
}


void generate_sequence(int length)
{
    const char* stances[] = {"horse", "lotus", "cat", "boat", "crane"};
    const char* left_or_right[] = {"on the left", "on the right"};
    int i;
    int num_of_stances = 5;
    int prev_stance = -1;
    int random_sequences;
    int random_direction;

    srand(time(NULL));


    printf("%s", stances[0]);
    for(i = 0; i < length -1; i++)
    {
        do
        {
            random_sequences = rand() % num_of_stances;
        }
        while(random_sequences == prev_stance || random_sequences == 0);

        if(random_sequences == 0)
        {
            printf(" - %s", stances[0]);
        }
        else
        {
            random_direction = rand() % 2;
            printf(" - %s %s",stances[random_sequences],left_or_right[random_direction]);
        }
        

    }
    printf("\n");
    printf("\n");
    printf("\n");
}

void generate_head_action(int length)
{
    const char* up_or_down[] = {"head up", "head down"};
    int i, random_head_action;

    srand(time(NULL));

    printf("%s", up_or_down[1]);
    for(i = 1; i < length; i++)
    {
        random_head_action = rand() % 2;
        printf(" - %s", up_or_down[random_head_action]);
    }
    printf("\n");
    printf("\n");
    printf("\n");
}

void generate_instrument_sequence(int length)
{
    const char* instrument_sequence[] = { "upbeat", "walkingbeat", "(10x)playbeat", "cleanup", "shortstops", "big7stars"};
    int i;
    int num_of_sequence = 6;
    int prev_sequence = -1;
    int random_sequences;
    int random_direction;
    int random_number = (rand() % 20) + 4;
    int add_cleanup = 0;

    srand(time(NULL));

    printf("bows - upbeat - big7stars - cleanup ");
    for(i = 0; i < length -1; i++)
    {
        do
        {
            random_sequences = rand() % num_of_sequence;
        }
        while(random_sequences == prev_sequence);

        if(strcmp(instrument_sequence[random_sequences], "shortstop") == 0)
        {
            printf(" - cleanup");
        }
        printf(" - %s", instrument_sequence[random_sequences]);
        prev_sequence = random_sequences;
    
    }



    printf(" - bows");
    printf("\n");
    printf("\n");
    printf("\n");
    printf("\n");

    printf("** NOTE - if shortstop appears but the cleanup does not appear right before shortstop\n");
    printf("   Play the cleanup after a beat and before shortstop\n");
    printf("   Example: _____ - cleanup - shortstop\n");
}


int main(void)
{
    int length;
    char drum_or_dance;


    
    srand(time(NULL));

    printf("How many stances would you like to do?\n");
    scanf("%d",&length);

    simulate_loading_dance(5,1);
    printf("\n");
    printf("\n");
    printf("\n");
    printf("Stances: \n");
    generate_sequence(length);
    printf("Head Movement: \n");
    generate_head_action(length);

    printf("How many sequence would you like to drum?\n");
    scanf("%d",&length);

    simulate_loading_drum(8,1);
    printf("\n");
    printf("\n");
    printf("\n");
    printf("Drumming Sequence: \n");
    generate_instrument_sequence(length);

    return 0;

}
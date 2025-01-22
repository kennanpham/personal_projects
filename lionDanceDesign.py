import random
import sys
import time

def simulate_loading_hk(duration=3, interval=0.5):
    end_time = time.time() + duration
    while time.time() < end_time:
        for i in range(4):
            sys.stdout.write("\rGenerating a design for a HK lion head" + "." * i)
            sys.stdout.flush()
            time.sleep(interval)
    sys.stdout.write("\rHere is your design!\n")

def simulate_loading_lfc(duration=3, interval=0.5):
    end_time = time.time() + duration
    while time.time() < end_time:
        for i in range(4):
            sys.stdout.write("\rGenerating a design for a lofuchi" + "." * i)
            sys.stdout.flush()
            time.sleep(interval)
    sys.stdout.write("\rHere is your color scheme to use!\n")

print("\nWelcome to Lion Dance Design Generator.\n")

HeadFrame = input("Would You like a Hoksan, Futsan, or Futhok? \n")

simulate_loading_hk()
print("Type of Head:        " + HeadFrame)

# Define color options
colors = ['red', 'orange', 'yellow', 'green', 'blue', 'purple', 'white', 'black', 'grey', 'pink', 'brown']
highlight_colors = ['red', 'orange', 'yellow', 'green', 'blue', 'purple', 'white', 'pink']
fur = ['red', 'orange', 'yellow', 'white', 'black', 'grey', 'brown']
type_of_fur = ['bristle', 'ram', 'sheep', 'wolf']

# Randomly select colors and remove them from the list to avoid repetition
base_color = random.choice(colors)
colors.remove(base_color)
second_base_color = random.choice(colors)
colors.remove(second_base_color)

# Select highlights from the highlight_colors list without removing from the colors list
highlights = random.choice(highlight_colors)
highlight_colors.remove(highlights)

# Select strokes from the colors list
main_strokes = random.choice(colors)
colors.remove(main_strokes)
secondary_strokes = random.choice(colors)
colors.remove(secondary_strokes)

# Select random fur color and type
random_fur = random.choice(fur)
random_type_of_fur = random.choice(type_of_fur)

# Display selected colors
print("Main base color:    " + base_color)
print("Second base color:  " + second_base_color)
print("Highlights:         " + highlights)
print("Main strokes:       " + main_strokes)
print("Secondary strokes:  " + secondary_strokes)
print("Fur color:          " + random_fur)
print("Type of Fur:        " + random_type_of_fur)

# Lazer paper selection
lazer_paper = ['gold', 'silver']

# Choose a random lazer paper and remove it from the list
choose_a_lazer = random.choice(lazer_paper)
lazer_paper.remove(choose_a_lazer)

# Select additional colors for the lofuchi
base_color_lfc = random.choice(colors)
colors.remove(base_color_lfc)
main_color_lfc = random.choice(colors)
colors.remove(main_color_lfc)

# Select highlights from the highlight_colors list without removing from the colors list
highlights_lfc = random.choice(highlight_colors)
highlight_colors.remove(highlights_lfc)

# Select strokes for the lofuchi
thick_strokes = random.choice(colors)
colors.remove(thick_strokes)
thin_strokes = random.choice(colors)
colors.remove(thin_strokes)

# Prompt for lofuchi preference
lofuchi = input("Would You like to have a lofuchi? [y/n] ")

if lofuchi == 'y':
    lofuchistyle = input("Which lofuchi style would you like? [hoksan/futsan]\n")
    lazer = input("Would you like to have a lazer paper? [y/n] ")
    
    # Display details for lofuchi with lazer
    if lazer == 'y':
        simulate_loading_lfc()
        print("Main Color:         " + main_color_lfc)
        print("Highlight:          " + highlights_lfc)
        print("Thick Strokes:      " + thick_strokes)
        print("Thin Strokes:       " + thin_strokes)
        print("Thank you for placing your order!")
        print("Your order will now take longer to deliver.")
    
    # Display details for lofuchi without lazer
    elif lazer == 'n':
        simulate_loading_lfc()
        print("Main Color:         " + main_color_lfc)
        print("Highlight:          " + highlights_lfc)
        print("Thick Strokes:      " + thick_strokes)
        print("Thin Strokes:       " + thin_strokes)
        print("Thank you for placing your order!")
        print("Your order will now take even longer to deliver.")

# Handle the case where the user does not want a lofuchi
elif lofuchi == 'n':
    print("Thank you for placing your order!")
    print("Your order will be done within a year or so.")

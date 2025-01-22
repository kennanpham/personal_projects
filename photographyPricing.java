import java.util.Scanner;

public class photographyPricing
{
    private static final double BASE_HOURLY_RATE = 40.0;
    private static final double EDITED_PHOTO_RATE = 5.0;
    private static final double EXPEDITED_DELIVERY_RATE = 30.0;
    private static final double ADDITIONAL_LOCATION_FEE = 15.0;
    private static final double ADDITIONAL_OUTFIT_FEE = 10.0;
    private static final double SENIOR_DISCOUNT = 0.1; // 10% discount
    private static final double RECOMMENDATION_DISCOUNT = 0.2; // 20% discount

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many hours would you like to shoot for the session?");
        float hours = scanner.nextFloat();

        System.out.println("How many edited photos would you like to have?");
        int editedPhotos = scanner.nextInt();

        System.out.println("Would you like your photo to be delivered within 1-2 days (y/n)");
        boolean expeditedDelivery = scanner.next().equalsIgnoreCase("y");

        System.out.println("Would you like to book a studio? (y/n)");
        boolean studioBooking = scanner.next().equalsIgnoreCase("y");

        System.out.println("Do you plan on doing 2 locations? (y/n)");
        boolean location = scanner.next().equalsIgnoreCase("y");

        System.out.println("Do you plan on using more than 1 outfit? (y/n)");
        boolean multipleOutfit = scanner.next().equalsIgnoreCase("y");

        System.out.println("Is your client a senior that's about to graduate high school or college? (y/n)");
        boolean isGraduating = scanner.next().equalsIgnoreCase("y");

        System.out.println("Did any of my previous clients recommend this client to me? (y/n)");
        boolean recommended = scanner.next().equalsIgnoreCase("y");
        String nameRecommended = "";
        if (recommended) 
        {
            scanner.nextLine(); // Consume the leftover newline character
            System.out.println("Please provide their Social Media handle below of the person who recommended you. (Example: Instagram - @casualportraits)");
            nameRecommended = scanner.nextLine();
        }

        // Calculate pricing details
        double[] pricingDetails = calculatePricing(
            hours, editedPhotos, expeditedDelivery, studioBooking, location, multipleOutfit, isGraduating, recommended, scanner
        );

        double total = pricingDetails[0];
        double studioCost = pricingDetails[1];
        int numOutfits = (int) pricingDetails[2];
        double seniorDiscount = pricingDetails[3];
        double recommendationDiscount = pricingDetails[4];

        // Print the summary
        System.out.println("\nHere is the summary of your photoshoot pricing:");
        System.out.printf("\nHours: %.2f", hours);
        System.out.printf("\nNumber of edited photos: %d", editedPhotos);
        System.out.println("\nFast Delivery: " + (expeditedDelivery ? "yes" : "no"));
        System.out.println("Studio Booking: " + (studioBooking ? "yes" : "no"));
        if (studioBooking) {
            System.out.printf("Cost of booking the studio: $%.2f\n", studioCost);
        }
        System.out.println("2 Locations: " + (location ? "yes" : "no"));
        System.out.println("More than 1 outfit: " + (multipleOutfit ? "yes" : "no"));
        if (multipleOutfit) {
            System.out.printf("Number of outfits: %d\n", numOutfits);
        }
        System.out.println("Senior graduating college/high school: " + (isGraduating ? "yes" : "no"));
        System.out.println("Recommended by someone: " + (recommended ? "yes" : "no"));
        if (recommended) {
            System.out.println("Social Media handle of the recommender: " + nameRecommended);
        }

        System.out.printf("\nYour total cost before discounts: $%.2f\n", total);
        if (isGraduating) {
            System.out.printf("Senior discount applied: -$%.2f\n", seniorDiscount);
        }
        if (recommended) {
            System.out.printf("Recommendation discount applied: -$%.2f\n", recommendationDiscount);
        }
        System.out.printf("Your total cost after discounts: $%.2f\n", total - seniorDiscount - recommendationDiscount);

        scanner.close();

        System.out.println("\n\nNote: Caps and gowns are free at no additional charge.\n\n");
    }

    public static double[] calculatePricing(float hours, int editedPhotos, boolean expeditedDelivery,
                                            boolean studioBooking, boolean location, boolean multipleOutfit,
                                            boolean isGraduating, boolean recommended, Scanner scanner) {
        double studioCost = 0;
        int numOutfits = 0;

        double total = hours * BASE_HOURLY_RATE;
        total += editedPhotos * EDITED_PHOTO_RATE;

        if (expeditedDelivery) 
        {
            total += EXPEDITED_DELIVERY_RATE;
        }

        if (studioBooking) 
        {
            System.out.println("How much does it cost to book the studio?");
            studioCost = scanner.nextDouble();
            total += studioCost;
        }

        if (location) 
        {
            total += ADDITIONAL_LOCATION_FEE;
        }

        if (multipleOutfit) 
        {
            System.out.println("How many outfits do you plan on using for the shoot?");
            numOutfits = scanner.nextInt();
            total += numOutfits * ADDITIONAL_OUTFIT_FEE;
        }

        double seniorDiscount = isGraduating ? total * SENIOR_DISCOUNT : 0;
        double recommendationDiscount = recommended ? total * RECOMMENDATION_DISCOUNT : 0;

        return new double[]{total, studioCost, numOutfits, seniorDiscount, recommendationDiscount};
    }
}

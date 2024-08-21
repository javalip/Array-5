import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateTax {
    /**
     * List of lists tax brackets
     * i to iterate through lisys
     * tax
     * leftover
     * salary
     *taxslab = lisy of double = incometax.get(i);
     * wherever i is present, it will get he tax slab.
     * limit
     *
     * taxable income = min(taxslab.get(0) - limit, leftover)
     * tax = tax +taxableincome*taxslab.get(1)
     * left = leftover-taxableincome
     * limit = taxslab/get(0)
     * i++
     * until leftovr income is zero repeat steps.
     *
     *
     */

    public static double calculateTax(List<List<Double>> allTaxSlabs, double salary ){
        int i=0;// iterating over taxslabs list
        double tax =0.0;
        double left = salary;
        double limit = 0.0;
        while(left>0){
            List<Double> taxSlab = allTaxSlabs.get(i);
            if(taxSlab.get(0)==null){
                return tax + left*taxSlab.get(1);
            }
            double taxableIncome = Math.min(taxSlab.get(0)-limit, left);
            tax = tax+taxableIncome*taxSlab.get(1);
            left = left - taxableIncome;
            limit = taxSlab.get(0);
            i++;
        }
        return tax;


    }

    public static void main (String[] args) {
        List<List<Double>> allTaxSlabs = new ArrayList<>();
        allTaxSlabs.add( Arrays.asList(10000.0, 0.3) );
        allTaxSlabs.add( Arrays.asList(20000.0, 0.2) );
        allTaxSlabs.add( Arrays.asList(30000.0, 0.1) );
        allTaxSlabs.add( Arrays.asList(null, 0.1) );
        double tax = calculateTax(allTaxSlabs,25000);
        System.out.println(tax);
    }


}

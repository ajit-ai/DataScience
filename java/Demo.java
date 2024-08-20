// Importing Libraries
import org.apache.commons.math3.analysis.function.Add;
import org.apache.commons.math3.analysis.function.Multiply;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import java.util.ArrayList;
import java.util.List;

public class GradientDescent {

    public static double meanSquaredError(double[] yTrue, double[] yPredicted) {
        // Calculating the loss or cost
        double cost = 0.0;
        for (int i = 0; i < yTrue.length; i++) {
            cost += Math.pow(yTrue[i] - yPredicted[i], 2);
        }
        return cost / yTrue.length;
    }

    // Gradient Descent Function
    // Here iterations, learningRate, stoppingThreshold
    // are hyperparameters that can be tuned
    public static double[] gradientDescent(double[] x, double[] y, int iterations, double learningRate, 
                                            double stoppingThreshold) {
        // Initializing weight, bias, learning rate and iterations
        double currentWeight = 0.1;
        double currentBias = 0.01;

        List<Double> costs = new ArrayList<>();
        List<Double> weights = new ArrayList<>();
        Double previousCost = null;

        // Estimation of optimal parameters 
        for (int i = 0; i < iterations; i++) {
            // Making predictions
            double[] yPredicted = new double[y.length];
            for (int j = 0; j < x.length; j++) {
                yPredicted[j] = (currentWeight * x[j]) + currentBias;
            }

            // Calculating the current cost
            double currentCost = meanSquaredError(y, yPredicted);

            // If the change in cost is less than or equal to 
            // stoppingThreshold we stop the gradient descent
            if (previousCost != null && Math.abs(previousCost - currentCost) <= stoppingThreshold) {
                break;
            }

            previousCost = currentCost;

            costs.add(currentCost);
            weights.add(currentWeight);

            // Calculating the gradients
            double weightDerivative = -(2.0 / x.length) * sumProduct(x, y, yPredicted);
            double biasDerivative = -(2.0 / x.length) * sum(y, yPredicted);

            // Updating weights and bias
            currentWeight = currentWeight - (learningRate * weightDerivative);
            currentBias = currentBias - (learningRate * biasDerivative);

            // Printing the parameters for each 1000th iteration
            System.out.printf("Iteration %d: Cost %.6f, Weight %.6f, Bias %.6f%n", i + 1, currentCost, currentWeight, currentBias);
        }

        // Visualizing the weights and cost at for all iterations (not implemented in this code)

        return new double[]{currentWeight, currentBias};
    }

    public static double sumProduct(double[] x, double[] y, double[] yPredicted) {
        double sum = 0.0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * (y[i] - yPredicted[i]);
        }
        return sum;
    }

    public static double sum(double[] y, double[] yPredicted) {
        double sum = 0.0;
        for (int i = 0; i < y.length; i++) {
            sum += (y[i] - yPredicted[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        // Data
        double[] X = {32.50234527, 53.42680403, 61.53035803, 47.47563963, 59.81320787,
                55.14218841, 52.21179669, 39.29956669, 48.10504169, 52.55001444,
                45.41973014, 54.35163488, 44.1640495, 58.16847072, 56.72720806,
                48.95588857, 44.68719623, 60.29732685, 45.61864377, 38.81681754};
        double[] Y = {31.70700585, 68.77759598, 62.5623823, 71.54663223, 87.23092513,
                78.21151827, 79.64197305, 59.17148932, 75.3312423, 71.30087989,
                55.16567715, 82.47884676, 62.00892325, 75.39287043, 81.43619216,
                60.72360244, 82.89250373, 97.37989686, 48.84715332, 56.87721319};

        // Estimating weight and bias using gradient descent
        double[] estimatedParameters = gradientDescent(X, Y, 2000, 0.0001, 1e-6);
        double estimatedWeight = estimatedParameters[0];
        double estimatedBias = estimatedParameters[1];
        System.out.printf("Estimated Weight: %.6f%nEstimated Bias: %.6f%n", estimatedWeight, estimatedBias);

        // Making predictions using estimated parameters
        double[] YPred = new double[Y.length];
        for (int i = 0; i < X.length; i++) {
            YPred[i] = estimatedWeight * X[i] + estimatedBias;
        }

        // Plotting the regression line (not implemented in this code)
    }
}
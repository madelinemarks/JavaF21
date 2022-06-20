public class Fraction
{
  private int numerator = 0;		// numerator (and keeps sign)
  private int denominator = 1;		// always stores positive value

  public Fraction()
  {
  }

  public Fraction(int n, int d)
  {
    if (set(n,d)==false)
	set(0,1);
  }

  public boolean set(int n, int d)
  {
    if (d > 0)
    {
	numerator = n;
	denominator = d;
	return true;
    }
    else
	return false;
  }
  
  public String toString()
  {
    return (numerator + "/" + denominator);
  }

  public int getNumerator()
  {
    return numerator;
  }

  public int getDenominator()
  {
    return denominator;
  }

  public double decimal()
  {
    return (double)numerator / denominator;
  }

  public Fraction simplify()
  {
    Fraction simplified = new Fraction();
    int gcd = 1;
    int tempNum, tempDenom;

    if (numerator < 0) 
    {
      tempNum  = numerator*-1;
      for(int i = 2; i <= tempNum && i <= denominator; i++)
        {
            if(tempNum%i==0 && denominator%i==0 && i != 0)
                gcd = i;
        }
      simplified.numerator = numerator/gcd;
      simplified.denominator = denominator/gcd;
    }
    else if (denominator < 0)
    {
      tempDenom = denominator*-1;
      for(int i = 2; i <= numerator && i <= tempDenom; i++)
        {
            if(numerator%i==0 && tempDenom%i==0 && i != 0)
                gcd = i;
        }
      simplified.numerator = numerator/gcd;
      simplified.denominator = denominator/gcd;
    }
    else 
    {
      for(int i = 2; i <= numerator && i <= denominator; i++)
          {
              if(numerator%i==0 && denominator%i==0 )
                  gcd = i;
          }
      
      simplified.numerator = numerator/gcd;
      simplified.denominator = denominator/gcd;
    }

    if (simplified.denominator < 0 && simplified.numerator > 1)
    {
      simplified.denominator *= -1;
      simplified.numerator *= -1;
    }

    return simplified;
  }

  public Fraction add(Fraction f)
  {
    Fraction result = new Fraction(0,1);

    result.numerator = (numerator*f.denominator) + (f.numerator*denominator);
    result.denominator = (denominator*f.denominator);

		return result.simplify();
  }

  public Fraction subtract(Fraction f)
  {
    Fraction result = new Fraction(0,1);

    result.numerator = (numerator*f.denominator) - (f.numerator*denominator);
    result.denominator = (denominator*f.denominator);

		return result.simplify();
  }

  public Fraction multiply(Fraction f)
  {
    Fraction result = new Fraction();

    result.numerator = f.numerator * numerator;
    result.denominator = f.denominator * denominator;

    return result.simplify();
  }

  public Fraction divide (Fraction f)
  {
    Fraction result = new Fraction();
    if (f.numerator == 0) {
      result.numerator = 0;
      result.denominator = 1;
    }
    else
    {
      result.numerator = numerator * f.denominator;
      result.denominator = denominator * f.numerator; 
    }
    return result.simplify();
  }

}
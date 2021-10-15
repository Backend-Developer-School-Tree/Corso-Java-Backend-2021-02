public class MyString
{
    private final String finalString;

    private MyString(Builder builder) { finalString = builder.intermediateString; }

    @Override
    public String toString() { return finalString.toString(); }

    public static class Builder
    {
        private String intermediateString = "";

        public Builder() {}

        public Builder(String initialString) { intermediateString = initialString; }

        public Builder append(String newString)
        {
            intermediateString += newString;
            return this;
        }

        public MyString build() { return new MyString(this); }
    }

    public static void main(String[] args)
    {
        MyString.Builder msb = new MyString.Builder();

        msb.append("Facilissimo")
           .append(" concatenare")
           .append(" stringhe!");

        MyString myFinalString = msb.build();

        System.out.println(myFinalString.toString());
    }
}
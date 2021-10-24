package hu.me.iit.webalk.dependency;

public class DependencyImpl implements Dependency {
    @Override
    public void helpNoParameterNoReturnValue() {}

    @Override
    public int helpNoParameterReturnValue() {
        return 45;
    }

    @Override
    public void helpWithParameterNoReturnValue(int a) {

    }
    @Override
	public String getImportant(String text) {
		text = text.substring(0, Math.min(text.length(), 3));
		text.format(text, "...");
		
		return text;
	}
}

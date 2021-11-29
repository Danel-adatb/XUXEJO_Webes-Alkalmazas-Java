package service;

public class NoSuchEntityExpection extends RuntimeException {
	private Long id;
		
		public NoSuchEntityExpection(Long id) {
			super(String.format("No such Entity %d", id));
			this.id = id;
		}
		
		public Long getId() {
	        return id;
	    }
}

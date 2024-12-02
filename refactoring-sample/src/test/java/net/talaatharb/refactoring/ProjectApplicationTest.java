package net.talaatharb.refactoring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RefactoringApplicationTest {

	@Test
	void testProjectStarts() {
		RefactoringApplication.main(null);
		assertTrue(true);
	}
}

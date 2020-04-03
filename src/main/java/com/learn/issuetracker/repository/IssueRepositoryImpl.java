package com.learn.issuetracker.repository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.learn.issuetracker.model.Issue;

/*
 * This class is used to read the issues data from the file and store it in a collection. Java8 NIO 
 * should be used to read the file in to streams
*/
public class IssueRepositoryImpl implements IssueRepository {

	/*
	 * This List will store the issue details read from the file
	 */
	private List<Issue> issues;

	/*
	 * issuesFilePath variable is used to store the path of issues.csv file
	 */
	private Path issuesFilePath;

	/*
	 * Initialize the member variables in the parameterized constructor
	 * initializeIssuesFromFile() method should be used in the constructor to
	 * initialize the 'issues' instance variable
	 *
	 */
	public IssueRepositoryImpl(Path issuesFilePath) {
		issuesFilePath=Paths.get("src", "data", "issues.csv");
		initializeIssuesFromFile();
	}

	/*
	 * This method should read the file from the path stored in variable
	 * 'issuesFilePath'. It should store the records read from the file in a List
	 * and initialize the 'issues' variable with this list. It should use
	 * 'parseIssue' method of Utility class for converting the line read from the
	 * file in to an Issue Object. Any issue with ISSUE ID, not starting with "IS",
	 * should not be stored in the "issues" List.
	 */

	public void initializeIssuesFromFile() {

	}

	/*
	 * Getter Method
	 */
	public List<Issue> getIssues() {
		return issues;
	}
}

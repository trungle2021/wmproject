package com.springboot.wmproject.repositories;

import com.springboot.wmproject.entities.TeamSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamSummaryRepository extends JpaRepository<TeamSummary,Integer> {
    String getSummaryTeamOrganization = """
            SELECT\s
                            Q1.team_id,
                            Q1.team_name AS team_name,
                            Q1.Total AS total_members,
                            Q2.name AS leader_name,
                            Q2.id As emp_id
                        FROM
                            (SELECT\s
                                team_id, team_name, COUNT(*) AS Total
                            FROM
                                employees e
                            JOIN organize_teams o ON e.team_id = o.id
                            GROUP BY team_name) AS Q1
                                LEFT JOIN
                            (SELECT\s
                                e.team_id, o.team_name, e.name, e.id
                            FROM
                                employees e
                            LEFT JOIN organize_teams o ON e.team_id = o.id
                            WHERE
                                e.is_leader = 1
                            GROUP BY team_name) AS Q2 ON Q1.team_id = Q2.team_id
            """;

    @Query(value = getSummaryTeamOrganization, nativeQuery = true)
    List<TeamSummary> getSummaryTeamOrganization();
}
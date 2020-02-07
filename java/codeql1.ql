import java

from Variable v
where v.getName().matches(".*query.*")
select v, "query found"
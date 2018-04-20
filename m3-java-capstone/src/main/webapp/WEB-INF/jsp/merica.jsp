<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:import url="/WEB-INF/jsp/common/header.jsp" />

    <section>
        <c:url var="merica" value="/img/merica.gif" />
        <img src="${merica}" />
    </section>

    <c:import url="/WEB-INF/jsp/common/footer.jsp" />

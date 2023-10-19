<div class="container sticky-top">
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
    <div class="col-md-3 mb-2 mb-md-0">
        <a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
            <svg class="bi" width="40" height="32" role="img" aria-label="Bootstrap">
                <use xlink:href="#bootstrap"></use>
            </svg>
        </a>
    </div>

    <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="./home" class="nav-link px-2 link-secondary">Home</a></li>
    </ul>

    <div class="col-md-3 text-end">
        <a href="./login" >
            <button type="button" class="btn btn-outline-primary me-2" style="display: ${display}">Login</button>
        </a>
        <a href="./${action}">
            <button type="button" class="btn btn-primary" >${status}</button>
        </a>
    </div>
</header>
</div>
const SearchBox = () => {
    return (
        <li className="nav-item">
            <div className="search-box" data-list='{"valueNames":["title"]}'>
                <form className="position-relative" data-bs-toggle="search" data-bs-display="static">
                    <input
                        className="form-control search-input fuzzy-search"
                        type="search"
                        placeholder="Search..."
                        aria-label="Search"
                    />
                    <span className="fas fa-search search-box-icon"></span>
                </form>
                <div
                    className="btn-close-falcon-container position-absolute end-0 top-50 translate-middle shadow-none"
                    data-bs-dismiss="search"
                >
                    <button className="btn btn-link btn-close-falcon p-0" aria-label="Close"></button>
                </div>
            </div>
        </li>
    );
};

export default SearchBox;

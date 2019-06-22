const express = require("express");
const router = express.Router();

// @route  api/users
// @desc   fetch user information
// @access public
router.get("/", (req, res) => res.send("user route"));

module.exports = router;

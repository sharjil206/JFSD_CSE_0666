let fun = () => {
  let date1 = new Date();
  let date2 = new Date("2028-07-14T00:00:00");
  let cel = date2 - date1;
  let days = Math.floor(cel / (1000 * 60 * 60 * 24));
  let hours = Math.floor((cel / (1000 * 60 * 60)) % 24);
  let mins = Math.floor((cel / (1000 * 60)) % 60);
  let secs = Math.floor((cel / 1000) % 60);
  let day = document.getElementById("day");
  day.innerHTML = days;
  let hour = document.getElementById("hour");
  hour.innerHTML = hours;
  let min = document.getElementById("minute");
  min.innerHTML = mins;
  let sec = document.getElementById("second");
  sec.innerHTML = secs;
};

setInterval(fun, 1000);

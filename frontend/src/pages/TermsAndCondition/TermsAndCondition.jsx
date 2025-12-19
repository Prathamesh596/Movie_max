import React from "react";
import { toast } from "react-toastify";
import PageHero from "../../components/PageHero";

const TermsAndConditions = () => {
  return (
    <>
      <PageHero
        title="Terms & Conditions"
        subtitle="Kindly review the terms carefully before proceeding"
        image="/images/theatre-photo.jpg"
        height="24vh"
      />

      <div className="container">
        <h3 className="fw-bold text-danger text-center mt-5 mb-4">
          Terms & Conditions
        </h3>

        <div className="mb-4">
          <p className="fw-bold text-danger">
            1. Pre-booked Food & Beverages must be collected from the designated
            F&B counter upon presentation of a valid booking ID.
          </p>

          <p className="fw-bold text-danger">
            2. For 3D movie screenings, charges for 3D glasses shall be applicable
            separately and are not included in the ticket price.
          </p>

          <p className="fw-bold text-danger">
            The following terms apply specifically to Large Screen / 3D
            screenings:
          </p>

          <ol>
            <li>
              The 3D glasses provided are premium-quality, sanitized, and issued
              exclusively to ensure viewer safety and comfort.
            </li>
            <li>
              These glasses are specifically designed for use on our large-format
              screens and are not compatible with other display systems.
            </li>
            <li>
              Patrons are requested to handle the 3D glasses with utmost care.
              Any loss or damage shall attract a replacement charge of
              <strong> ₹2000/-</strong>.
            </li>
            <li>
              All 3D glasses must be returned to the theatre staff before exiting
              the auditorium.
            </li>
            <li>
              Kindly ensure that the 3D glasses are not left behind on seats
              after the show.
            </li>
            <li>
              Charges for 3D glasses are applicable in addition to the ticket
              price.
            </li>
            <li>
              One pair of 3D glasses shall be issued per valid movie ticket.
            </li>
            <li>
              Children aged 3 years and above are required to hold a valid movie
              ticket.
            </li>
          </ol>

          <p className="fw-bold text-danger mt-4">
            Cancellation & Refund Policy:
          </p>

          <ul>
            <li>
              Cancellation requests can be initiated only after 10 minutes from
              the time of ticket or F&B booking.
            </li>
            <li>
              No cancellations shall be permitted within 20 minutes prior to the
              scheduled showtime.
            </li>
            <li>
              For cancellations made more than 2 hours before showtime, 75% of
              the ticket amount and 100% of the F&B amount will be refunded.
            </li>
            <li>
              For cancellations made between 20 minutes and 2 hours before
              showtime, 50% of the ticket amount and 100% of the F&B amount will
              be refunded.
            </li>
            <li>
              F&B bookings made independently (without a movie ticket) are not
              eligible for cancellation or refund.
            </li>
            <li>
              No refunds shall be applicable for bookings made using
              M-coupons, Gift Cards, Star Passes, Vouchers, Promotional offers,
              corporate bookings, special screenings, or block bookings.
            </li>
            <li>
              Cancellation benefits cannot be combined with any offers,
              discounts, or partner-facilitated bookings.
            </li>
            <li>
              Partial cancellations are strictly not permitted. The entire
              transaction must be cancelled as a whole.
            </li>
            <li>
              Transactions completed using multiple payment modes are not
              eligible for partial cancellation.
            </li>
            <li>
              Convenience fees and applicable taxes are non-refundable under any
              circumstances.
            </li>
            <li>
              Approved refunds shall be processed within a minimum of 7 working
              days from the date of cancellation.
            </li>
            <li>
              The company reserves the right to amend, modify, suspend, or
              withdraw these terms and conditions without prior notice.
            </li>
            <li>
              Ticket cancellations are not applicable for bookings made at the
              Box Office or at selected listed properties.
            </li>
            <li>
              Transactions involving redeemed reward points are not eligible
              for cancellation.
            </li>
            <li>
              In the event of any dispute, the decision of the management shall
              be final and binding.
            </li>
          </ul>
        </div>

        <div className="d-flex justify-content-between mb-5">
          <button className="btn btn-light border">Cancel</button>
          <button
            className="btn btn-danger"
            onClick={() =>
              toast.success(
                "You have successfully accepted the Terms & Conditions."
              )
            }
          >
            Accept
          </button>
        </div>
      </div>
    </>
  );
};

export default TermsAndConditions;
